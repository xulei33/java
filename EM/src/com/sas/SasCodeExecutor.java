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
		log.info("开始初始化sas连接服务......");
		Properties sasInfo = new Properties();
		sasInfo.load(SasCodeExecutor.class.getClassLoader().getResourceAsStream("sas.server.properties"));

		String host = sasInfo.getProperty("workspace.server.host");
		int port = Integer.parseInt(sasInfo.getProperty("workspace.server.port"));

		Server server = new BridgeServer(Server.CLSID_SAS, host, port);
		Cluster cluster = new LoadBalancingCluster(server);

		String userName = sasInfo.getProperty("workspace.server.user");
		String password = sasInfo.getProperty("workspace.server.password");
		// 服务器登陆设置
		login = new PasswordCredential(userName, password);

		// 创建允许连接到服务器的用户集
		Set<Credential> authorizedLogins = new HashSet<>(1);
		authorizedLogins.add(login);

		// 创建一个连接池
		Puddle puddle = new Puddle(cluster, login);
		puddle.setUserCredentials(authorizedLogins);

		int minSize = Integer.parseInt(sasInfo.getProperty("workspace.server.minSize"));
		int minAvail = Integer.parseInt(sasInfo.getProperty("workspace.server.minAvail"));

		puddle.setMinSize(minSize);
		puddle.setMinAvail(minAvail);

		// 创建连接池的连接工厂配置
		ConnectionFactoryConfiguration cxfConfig = new ManualConnectionFactoryConfiguration(puddle);

		// 获取匹配配置的连接工厂
		ConnectionFactoryManager cxfManager = new ConnectionFactoryManager();
		log.info("完成初始化sas连接服务");
		try {
			cxf = cxfManager.getFactory(cxfConfig);
		} catch (ConnectionFactoryException cfe) {
			log.error("***获取sas服务连接工厂出错！***", cfe);
			throw cfe;
		}

	}

	public static void execute(String sasCode) throws Exception {
		if (cxf == null) {
			log.error("***SasCodeExecuter尚未执行初始化，无法执行指定脚本***");
			throw new Exception("***SasCodeExecuter尚未执行初始化，无法执行指定脚本***");
		}

		ConnectionInterface conn = null;

		try {
			conn = cxf.getConnection(login);
		} catch (Exception ise) {
			log.error("***获取sas服务连接失败***", ise);
			log.info("准备重新初始化sas服务连接池");
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
			log.info("准备执行sas脚本:" + sasCode);
			sasLanguage.Submit(sasCode);
			System.out.println(sasLanguage.FlushLog(1000000));
			log.info("结束执行sas脚本:" + sasCode);
		} catch (Exception e) {
			log.error("***执行指定sas code 出错***", e);
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
