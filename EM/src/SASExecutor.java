
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sas.SasCodeExecutor;
import com.sas.iom.SAS.ILanguageService;
import com.sas.iom.SAS.IWorkspace;
import com.sas.iom.SAS.IWorkspaceHelper;
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

public class SASExecutor {

	private static Log log = LogFactory.getLog(SASExecutor.class);
	private static Credential login;
	private static ConnectionFactoryInterface cxf;
	private final static ReentrantLock lock = new ReentrantLock();

	public static void init(String host, String userName, String password) throws IOException, ConnectionFactoryException {
		log.info("开始初始化sas连接服务......");
		Properties sasInfo = new Properties();
		sasInfo.load(SASExecutor.class.getClassLoader().getResourceAsStream("sas.server.properties"));

//		String host = sasInfo.getProperty("workspace.server.host");
		int port = Integer.parseInt(sasInfo.getProperty("workspace.server.port"));

		Server server = new BridgeServer(Server.CLSID_SAS, host, port);
		Cluster cluster = new LoadBalancingCluster(server);

//		String userName = sasInfo.getProperty("workspace.server.user");
//		String password = sasInfo.getProperty("workspace.server.password");
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

	public static void execute(String host, String userName, String password,String sasCode) throws Exception {
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
					init(host,userName,password);
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

		String server = "rdcesx09087.race.sas.com";
		String user = "sasdemo";
		String pwd = "Go4thsas";
		String sascode = "proc setinit;run;";

		if (args.length == 0) {
			System.out.println("程序使用方式为: java -jar CallSASCode.jar 服务器IP 用户名 密码 SAS模型");
			System.exit(0);
		}
		if (args.length == 3) {
			server = args[0];
			user = args[1];
			pwd = args[2];
			init(server,user,pwd);
			SASExecutor.execute(server,user,pwd,sascode);
			System.out.println("程序使用方式为: java -jar CallSASCode.jar 服务器IP 用户名 密码 SAS模型");
		} else if (args.length == 4) {
			server = args[0];
			user = args[1];
			pwd = args[2];
			SASExecutor.init(server,user,pwd);
			sascode = "%include '" + args[3] + "';";
			SASExecutor.execute(server,user,pwd,sascode);
		} else {
			System.out.println("程序使用方式为: java -jar CallSASCode.jar 服务器IP 用户名 密码 SAS模型");
			System.exit(0);
		}
//		SasCodeExecutor.execute("%include '/local/install/users/sasdemo/tmp/logistic_model.sas';");
	}

}
