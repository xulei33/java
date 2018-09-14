package com.sas;

import com.sas.iom.SAS.ILanguageService;
import com.sas.iom.SAS.IWorkspace;
import com.sas.iom.SAS.IWorkspaceHelper;
import com.sas.services.connection.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class SasCodeExecutor {

	private static Log log = LogFactory.getLog(SasCodeExecutor.class);
	private static Credential login;
	private static ConnectionFactoryInterface cxf;
	private final static ReentrantLock lock = new ReentrantLock();

	public static void init() throws IOException, ConnectionFactoryException {
		log.info("��ʼ��ʼ��sas���ӷ���......");
		Properties sasInfo = new Properties();
		sasInfo.load(SasCodeExecutor.class.getClassLoader().getResourceAsStream("sas.server.properties"));

		String host = sasInfo.getProperty("workspace.server.host");
		int port = Integer.parseInt(sasInfo.getProperty("workspace.server.port"));

		Server server = new BridgeServer(Server.CLSID_SAS, host, port);
		Cluster cluster = new LoadBalancingCluster(server);

		String userName = sasInfo.getProperty("workspace.server.user");
		String password = sasInfo.getProperty("workspace.server.password");
		// ��������½����
		login = new PasswordCredential(userName, password);

		// �����������ӵ����������û���
		Set<Credential> authorizedLogins = new HashSet<>(1);
		authorizedLogins.add(login);

		// ����һ�����ӳ�
		Puddle puddle = new Puddle(cluster, login);
		puddle.setUserCredentials(authorizedLogins);

		int minSize = Integer.parseInt(sasInfo.getProperty("workspace.server.minSize"));
		int minAvail = Integer.parseInt(sasInfo.getProperty("workspace.server.minAvail"));

		puddle.setMinSize(minSize);
		puddle.setMinAvail(minAvail);

		// �������ӳص����ӹ�������
		ConnectionFactoryConfiguration cxfConfig = new ManualConnectionFactoryConfiguration(puddle);

		// ��ȡƥ�����õ����ӹ���
		ConnectionFactoryManager cxfManager = new ConnectionFactoryManager();
		log.info("��ɳ�ʼ��sas���ӷ���");
		try {
			cxf = cxfManager.getFactory(cxfConfig);
		} catch (ConnectionFactoryException cfe) {
			log.error("***��ȡsas�������ӹ�������***", cfe);
			throw cfe;
		}

	}

	public static void execute(String sasCode) throws Exception {
		if (cxf == null) {
			log.error("***SasCodeExecuter��δִ�г�ʼ�����޷�ִ��ָ���ű�***");
			throw new Exception("***SasCodeExecuter��δִ�г�ʼ�����޷�ִ��ָ���ű�***");
		}

		ConnectionInterface conn = null;

		try {
			conn = cxf.getConnection(login);
		} catch (Exception ise) {
			log.error("***��ȡsas��������ʧ��***", ise);
			log.info("׼�����³�ʼ��sas�������ӳ�");
			if (!lock.isLocked()) {
				try {
					lock.lock();
					init();
				} finally {
					lock.unlock();
				}
			} else {
				Thread.sleep(3000);
			}
			conn = cxf.getConnection(login);
		}

		try {
			org.omg.CORBA.Object obj = conn.getObject();
			IWorkspace sasWorkspace = IWorkspaceHelper.narrow(obj);
			ILanguageService sasLanguage = sasWorkspace.LanguageService();
			log.info("׼��ִ��sas�ű�:" + sasCode);
			sasLanguage.Submit(sasCode);
			System.out.println(sasLanguage.FlushLog(1000000));
			log.info("����ִ��sas�ű�:" + sasCode);
		} catch (Exception e) {
			log.error("***ִ��ָ��sas code ����***", e);
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		SasCodeExecutor.init();
		String sascode = "proc setinit;run;";

		if (args.length == 1) {
			sascode = "%include '" + args[0] + "';";
		}
		SasCodeExecutor.execute(sascode);
//		SasCodeExecutor.execute("%include '/local/install/users/sasdemo/tmp/logistic_model.sas';");
	}

}
