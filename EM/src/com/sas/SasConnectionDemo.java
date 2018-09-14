package com.sas;

import java.sql.Statement;

import com.sas.iom.SAS.ILanguageService;
import com.sas.iom.SAS.IWorkspace;
import com.sas.iom.SAS.IWorkspaceHelper;
import com.sas.iom.SAS.ILanguageServicePackage.CarriageControlSeqHolder;
import com.sas.iom.SAS.ILanguageServicePackage.LineTypeSeqHolder;
import com.sas.iom.SASIOMDefs.GenericError;
import com.sas.iom.SASIOMDefs.StringSeqHolder;
import com.sas.rio.MVAConnection;
import com.sas.services.connection.ConnectionFactoryException;
import com.sas.services.connection.ConnectionInterface;

/**
 * SAS脚本调用示例
 *
 * @author Young.Free
 * @since JDK 1.6
 */
public class SasConnectionDemo {
    public static void main(String[] args) throws Exception {
        SasPoolConnection.newSasPoolConnection(); // 初始化，创建连接池
        MVAConnection jdbcConnection = null;
        Statement stmt = null;
        IWorkspace sasWorkspace = null;
        ConnectionInterface ci = null;

        try {

            //连接池获取链接
            ci = SasPoolConnection.getConnection();
            org.omg.CORBA.Object obj1 = ci.getObject();
            sasWorkspace = IWorkspaceHelper.narrow(obj1);

            ILanguageService sasLanguage = sasWorkspace.LanguageService();
            //String sas_code = "%include '/sas/get_all_groups_and_user.sas';";
            String sas_code = "%include '/sas/cd/sascode/get_all_groups_and_user.sas';";
            sasLanguage.Submit(sas_code);
            // Retrieve the SAS log and print it out
            CarriageControlSeqHolder logCarriageControlHldr = new CarriageControlSeqHolder();
            LineTypeSeqHolder logLineTypeHldr = new LineTypeSeqHolder();
            StringSeqHolder logHldr = new StringSeqHolder();
            sasLanguage.FlushLogLines(Integer.MAX_VALUE, logCarriageControlHldr, logLineTypeHldr, logHldr);
            String[] logLines = logHldr.value;

        } catch (ConnectionFactoryException e) {
            e.printStackTrace();
        } catch (GenericError e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //sasWorkspace.Close();
                if (null != ci) {
                    //释放连接到连接池
                    SasPoolConnection.closeConnection(ci);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
