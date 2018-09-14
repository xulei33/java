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
 * sas连接池
 * //获取连接 
 * ConnectionInterface ci = SasPoolConnection.getConnection();
 * Object obj1 = ci.getObject(); 
 * IWorkspace iWorkspace1 =IWorkspaceHelper.narrow(obj1);
 *  //释放连接到连接池
 * SasPoolConnection.closeConnection(ci);//或者 ci.close();
 */
public class SasPoolConnection {
	private static ConnectionFactoryInterface cxf;
	private static Credential login;
	static Log log = LogFactory.getLog(SasPoolConnection.class);

	/**
	 * 初始化SAS连接池
	 */
	public static void newSasPoolConnection() throws IOException {
		log.info("初始化SAS连接池");

		// 获取配置信息
		Properties prop = new Properties();
		prop.load(SasPoolConnection.class.getClassLoader().getResourceAsStream("sas.server.properties"));

		String classID = Server.CLSID_SAS;
		String host = prop.getProperty("workspace.server.host");
		int port = Integer.parseInt(prop.getProperty("workspace.server.port"));
		String userName = prop.getProperty("workspace.server.user");
		String password = prop.getProperty("workspace.server.password");

		// 解密password
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

		// 服务器登陆设置
		login = new PasswordCredential(userName, password);

		// 创建允许连接到服务器的用户集
		Set authorizedLogins = new HashSet();
		authorizedLogins.add(login);
		// 创建一个连接池
		Puddle puddle = new Puddle(cluster, login);
		puddle.setUserCredentials(authorizedLogins);

		// 最小连接数
		int minSize = Integer.parseInt(prop.getProperty("workspace.server.minSize"));
		int minAvail = Integer.parseInt(prop.getProperty("workspace.server.minAvail"));

		puddle.setMinSize(minSize);
		puddle.setMinAvail(minAvail);

		// 创建连接池的连接工厂配置
		ConnectionFactoryConfiguration cxfConfig = new ManualConnectionFactoryConfiguration(puddle);

		// 获取匹配配置的连接工厂
		ConnectionFactoryManager cxfManager = new ConnectionFactoryManager();

		try {
			cxf = cxfManager.getFactory(cxfConfig);
		} catch (ConnectionFactoryException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 从连接池中获取连接，使用完毕后需要调用closeConnection释放连接
	 *
	 * @return ConnectionInterface
	 * @throws ConnectionFactoryException
	 */
	public static ConnectionInterface getConnection() throws ConnectionFactoryException, IOException {
		ConnectionInterface ci = null;
		try {
			Long startTime = System.currentTimeMillis();
			ci = cxf.getConnection(login);
			log.info("从SAS连接池获取连接,用时 " + (System.currentTimeMillis() - startTime) / 1000.0 + " 秒");
			return ci;
		} catch (Exception e) {
			log.info("==================调用SAS连接池失败，重新建立SAS连接池==================");
			newSasPoolConnection(); // 重新建立SAS连接池
			e.printStackTrace();
		}
		return ci;
	}

	/**
	 * 释放连接到连接池
	 */
	public static void closeConnection(ConnectionInterface ci) {
		log.debug("释放连接到SAS连接池");
		ci.close();
	}

}
