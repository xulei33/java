package com.sas;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sas.services.connection.BridgeServer;
import com.sas.services.connection.Cluster;
import com.sas.services.connection.ConnectionFactoryConfiguration;
import com.sas.services.connection.ConnectionFactoryException;
import com.sas.services.connection.ConnectionFactoryInterface;
import com.sas.services.connection.ConnectionFactoryManager;
import com.sas.services.connection.ConnectionInterface;
import com.sas.services.connection.Credential;
import com.sas.services.connection.LoadBalancingCluster;
import com.sas.services.connection.ManualConnectionFactoryConfiguration;
import com.sas.services.connection.PasswordCredential;
import com.sas.services.connection.Puddle;
import com.sas.services.connection.Server;

/**
 * sas���ӳ�
 * //��ȡ���� 
 * ConnectionInterface ci = SasPoolConnection.getConnection();
 * Object obj1 = ci.getObject(); 
 * IWorkspace iWorkspace1 =IWorkspaceHelper.narrow(obj1);
 *  //�ͷ����ӵ����ӳ�
 * SasPoolConnection.closeConnection(ci);//���� ci.close();
 */
public class SasPoolConnection {
	private static ConnectionFactoryInterface cxf;
	private static Credential login;
	static Log log = LogFactory.getLog(SasPoolConnection.class);

	/**
	 * ��ʼ��SAS���ӳ�
	 */
	public static void newSasPoolConnection() throws IOException {
		log.info("��ʼ��SAS���ӳ�");

		// ��ȡ������Ϣ
		Properties prop = new Properties();
		prop.load(SasPoolConnection.class.getClassLoader().getResourceAsStream("sas.server.properties"));

		String classID = Server.CLSID_SAS;
		String host = prop.getProperty("workspace.server.host");
		int port = Integer.parseInt(prop.getProperty("workspace.server.port"));
		String userName = prop.getProperty("workspace.server.user");
		String password = prop.getProperty("workspace.server.password");

		// ����password
//        try {
//            byte[] src = Base64.decode(password);
//            byte[] reverse = CryptUtil.decryptWithPrivateKey(src,
//                    CryptManager.getPrivatekey(),
//                    CryptManager.DEFAULT_CIPHER_STRENGTH);
//            password = new String(reverse);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

		Server server = new BridgeServer(classID, host, port);
		Cluster cluster = new LoadBalancingCluster(server);

		// ��������½����
		login = new PasswordCredential(userName, password);

		// �����������ӵ����������û���
		Set authorizedLogins = new HashSet();
		authorizedLogins.add(login);
		// ����һ�����ӳ�
		Puddle puddle = new Puddle(cluster, login);
		puddle.setUserCredentials(authorizedLogins);

		// ��С������
		int minSize = Integer.parseInt(prop.getProperty("workspace.server.minSize"));
		int minAvail = Integer.parseInt(prop.getProperty("workspace.server.minAvail"));

		puddle.setMinSize(minSize);
		puddle.setMinAvail(minAvail);

		// �������ӳص����ӹ�������
		ConnectionFactoryConfiguration cxfConfig = new ManualConnectionFactoryConfiguration(puddle);

		// ��ȡƥ�����õ����ӹ���
		ConnectionFactoryManager cxfManager = new ConnectionFactoryManager();

		try {
			cxf = cxfManager.getFactory(cxfConfig);
		} catch (ConnectionFactoryException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * �����ӳ��л�ȡ���ӣ�ʹ����Ϻ���Ҫ����closeConnection�ͷ�����
	 *
	 * @return ConnectionInterface
	 * @throws ConnectionFactoryException
	 */
	public static ConnectionInterface getConnection() throws ConnectionFactoryException, IOException {
		ConnectionInterface ci = null;
		try {
			Long startTime = System.currentTimeMillis();
			ci = cxf.getConnection(login);
			log.info("��SAS���ӳػ�ȡ����,��ʱ " + (System.currentTimeMillis() - startTime) / 1000.0 + " ��");
			return ci;
		} catch (Exception e) {
			log.info("==================����SAS���ӳ�ʧ�ܣ����½���SAS���ӳ�==================");
			newSasPoolConnection(); // ���½���SAS���ӳ�
			e.printStackTrace();
		}
		return ci;
	}

	/**
	 * �ͷ����ӵ����ӳ�
	 */
	public static void closeConnection(ConnectionInterface ci) {
		log.debug("�ͷ����ӵ�SAS���ӳ�");
		ci.close();
	}

}
