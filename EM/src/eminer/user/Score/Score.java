/*-----------------------------------------------------------
Copyright (C) 2001 SAS Institute, Inc. All rights reserved.
 
Notice:
 The following permissions are granted provided that the
 above copyright and this notice appear in the code and
 any related documentation. Permission to copy, modify and
 distribute code generated using or distributed with
 SAS Enterprise Miner J*Score software and any executables
 derived from such source code is limited to customers of
 SAS Institute with a valid license for SAS Enterprise Miner
 J*Score software. Any distribution of such code in any form
 shall be on an "AS IS" basis without warranty of any kind.
 SAS and all other SAS Institute Inc. product and service
 names are registered trademarks or trademarks of SAS 
 Institute Inc. in the USA and other countries. Except as 
 contained in this notice, the name of SAS Institute, SAS 
 Enterprise Miner and SAS Enterprise Miner J*Score software 
 shall not be used in the advertising or promotion of 
 products or services without prior written authorization 
 from SAS Institute Inc.
------------------------------------------------------------*/
 
package eminer.user.Score;
import java.util.Map;
import java.util.HashMap;
import com.sas.ds.*;
import com.sas.analytics.eminer.jscore.util.*;
 
 
/** 
* The Score class encapsulates data step scoring code generated
* by the SAS Enterprise Miner Java Scoring Component.
*                                                              
* @since 1.0
* @version Jscore 1.2
* @author SAS Enterprise Miner Java Scoring Component
* @see com.sas.analytics.eminer.jscore.util.Jscore
*/ 
 
public class Score
       implements Jscore {
   private boolean dataModified;
   public boolean reuseOutputMap;
   private DS dscode;
 
/** 
* A map of the (key) name, (value) reference pair for every 
* variable modified by the score method.
* This is provided primarily for optional advanced development.
*/ 
   protected Map outputVariables;
 
   public Score() {
      DSFormats formatLib = new JscoreUserFormats();
      dataModified = false;
      reuseOutputMap = false;
      dscode = new DS(formatLib);
   }
 
 
/** 
* Executes the scoring code and returns an output Map.
* By default a new instance of the output map is allocated
* the method is invoked. To modify this behavior set the public
* field reuseOutputMap to true. This will cause only one
* output map to be allocated, subsequent calls will reuse the
* same map. Note this will cause the content of the map to be
* over written at each time this method is invoked.
* @param a reference to a Map object that contains the
* (key) name String, (value) pair, for the
* input variables to be used in the "scoring" code.
* @return a Map of the (key) name, (value) reference pair for all 
* variables modified in the "scoring" code.
* @throws com.sas.analytics.eminer.jscore.util.JscoreException Invalid input data type for String \"variableName\".
* @throws com.sas.analytics.eminer.jscore.util.JscoreException Invalid input data type for Double \"variableName\".
*/ 
   public Map score ( Map indata) throws JscoreException {
      Object tmpVar;
 
      dscode.initialize();
      if ( reuseOutputMap == false || outputVariables == null)
           outputVariables = new HashMap( 28, .75F );
 
      tmpVar = indata.get("A1");
      if( tmpVar != null) {
         try {
             dscode.A1 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A1\".");
         }
      }
      else 
         dscode.A1 = Double.NaN;
 
      tmpVar = indata.get("A10");
      if( tmpVar != null) {
         try {
             dscode.A10 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A10\".");
         }
      }
      else 
         dscode.A10 = Double.NaN;
 
      tmpVar = indata.get("A100");
      if( tmpVar != null) {
         try {
             dscode.A100 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A100\".");
         }
      }
      else 
         dscode.A100 = Double.NaN;
 
      tmpVar = indata.get("A1000");
      if( tmpVar != null) {
         try {
             dscode.A1000 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A1000\".");
         }
      }
      else 
         dscode.A1000 = Double.NaN;
 
      tmpVar = indata.get("A101");
      if( tmpVar != null) {
         try {
             dscode.A101 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A101\".");
         }
      }
      else 
         dscode.A101 = Double.NaN;
 
      tmpVar = indata.get("A103");
      if( tmpVar != null) {
         try {
             dscode.A103 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A103\".");
         }
      }
      else 
         dscode.A103 = Double.NaN;
 
      tmpVar = indata.get("A104");
      if( tmpVar != null) {
         try {
             dscode.A104 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A104\".");
         }
      }
      else 
         dscode.A104 = Double.NaN;
 
      tmpVar = indata.get("A107");
      if( tmpVar != null) {
         try {
             dscode.A107 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A107\".");
         }
      }
      else 
         dscode.A107 = Double.NaN;
 
      tmpVar = indata.get("A109");
      if( tmpVar != null) {
         try {
             dscode.A109 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A109\".");
         }
      }
      else 
         dscode.A109 = Double.NaN;
 
      tmpVar = indata.get("A11");
      if( tmpVar != null) {
         try {
             dscode.A11 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A11\".");
         }
      }
      else 
         dscode.A11 = Double.NaN;
 
      tmpVar = indata.get("A112");
      if( tmpVar != null) {
         try {
             dscode.A112 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A112\".");
         }
      }
      else 
         dscode.A112 = Double.NaN;
 
      tmpVar = indata.get("A113");
      if( tmpVar != null) {
         try {
             dscode.A113 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A113\".");
         }
      }
      else 
         dscode.A113 = Double.NaN;
 
      tmpVar = indata.get("A114");
      if( tmpVar != null) {
         try {
             dscode.A114 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A114\".");
         }
      }
      else 
         dscode.A114 = Double.NaN;
 
      tmpVar = indata.get("A115");
      if( tmpVar != null) {
         try {
             dscode.A115 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A115\".");
         }
      }
      else 
         dscode.A115 = Double.NaN;
 
      tmpVar = indata.get("A116");
      if( tmpVar != null) {
         try {
             dscode.A116 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A116\".");
         }
      }
      else 
         dscode.A116 = Double.NaN;
 
      tmpVar = indata.get("A117");
      if( tmpVar != null) {
         try {
             dscode.A117 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A117\".");
         }
      }
      else 
         dscode.A117 = Double.NaN;
 
      tmpVar = indata.get("A12");
      if( tmpVar != null) {
         try {
             dscode.A12 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A12\".");
         }
      }
      else 
         dscode.A12 = Double.NaN;
 
      tmpVar = indata.get("A120");
      if( tmpVar != null) {
         try {
             dscode.A120 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A120\".");
         }
      }
      else 
         dscode.A120 = Double.NaN;
 
      tmpVar = indata.get("A121");
      if( tmpVar != null) {
         try {
             dscode.A121 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A121\".");
         }
      }
      else 
         dscode.A121 = Double.NaN;
 
      tmpVar = indata.get("A122");
      if( tmpVar != null) {
         try {
             dscode.A122 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A122\".");
         }
      }
      else 
         dscode.A122 = Double.NaN;
 
      tmpVar = indata.get("A123");
      if( tmpVar != null) {
         try {
             dscode.A123 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A123\".");
         }
      }
      else 
         dscode.A123 = Double.NaN;
 
      tmpVar = indata.get("A125");
      if( tmpVar != null) {
         try {
             dscode.A125 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A125\".");
         }
      }
      else 
         dscode.A125 = Double.NaN;
 
      tmpVar = indata.get("A128");
      if( tmpVar != null) {
         try {
             dscode.A128 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A128\".");
         }
      }
      else 
         dscode.A128 = Double.NaN;
 
      tmpVar = indata.get("A129");
      if( tmpVar != null) {
         try {
             dscode.A129 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A129\".");
         }
      }
      else 
         dscode.A129 = Double.NaN;
 
      tmpVar = indata.get("A13");
      if( tmpVar != null) {
         try {
             dscode.A13 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A13\".");
         }
      }
      else 
         dscode.A13 = Double.NaN;
 
      tmpVar = indata.get("A131");
      if( tmpVar != null) {
         try {
             dscode.A131 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A131\".");
         }
      }
      else 
         dscode.A131 = Double.NaN;
 
      tmpVar = indata.get("A132");
      if( tmpVar != null) {
         try {
             dscode.A132 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A132\".");
         }
      }
      else 
         dscode.A132 = Double.NaN;
 
      tmpVar = indata.get("A133");
      if( tmpVar != null) {
         try {
             dscode.A133 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A133\".");
         }
      }
      else 
         dscode.A133 = Double.NaN;
 
      tmpVar = indata.get("A134");
      if( tmpVar != null) {
         try {
             dscode.A134 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A134\".");
         }
      }
      else 
         dscode.A134 = Double.NaN;
 
      tmpVar = indata.get("A136");
      if( tmpVar != null) {
         try {
             dscode.A136 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A136\".");
         }
      }
      else 
         dscode.A136 = Double.NaN;
 
      tmpVar = indata.get("A138");
      if( tmpVar != null) {
         try {
             dscode.A138 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A138\".");
         }
      }
      else 
         dscode.A138 = Double.NaN;
 
      tmpVar = indata.get("A139");
      if( tmpVar != null) {
         try {
             dscode.A139 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A139\".");
         }
      }
      else 
         dscode.A139 = Double.NaN;
 
      tmpVar = indata.get("A14");
      if( tmpVar != null) {
         try {
             dscode.A14 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A14\".");
         }
      }
      else 
         dscode.A14 = Double.NaN;
 
      tmpVar = indata.get("A140");
      if( tmpVar != null) {
         try {
             dscode.A140 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A140\".");
         }
      }
      else 
         dscode.A140 = Double.NaN;
 
      tmpVar = indata.get("A141");
      if( tmpVar != null) {
         try {
             dscode.A141 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A141\".");
         }
      }
      else 
         dscode.A141 = Double.NaN;
 
      tmpVar = indata.get("A142");
      if( tmpVar != null) {
         try {
             dscode.A142 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A142\".");
         }
      }
      else 
         dscode.A142 = Double.NaN;
 
      tmpVar = indata.get("A143");
      if( tmpVar != null) {
         try {
             dscode.A143 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A143\".");
         }
      }
      else 
         dscode.A143 = Double.NaN;
 
      tmpVar = indata.get("A147");
      if( tmpVar != null) {
         try {
             dscode.A147 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A147\".");
         }
      }
      else 
         dscode.A147 = Double.NaN;
 
      tmpVar = indata.get("A148");
      if( tmpVar != null) {
         try {
             dscode.A148 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A148\".");
         }
      }
      else 
         dscode.A148 = Double.NaN;
 
      tmpVar = indata.get("A149");
      if( tmpVar != null) {
         try {
             dscode.A149 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A149\".");
         }
      }
      else 
         dscode.A149 = Double.NaN;
 
      tmpVar = indata.get("A15");
      if( tmpVar != null) {
         try {
             dscode.A15 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A15\".");
         }
      }
      else 
         dscode.A15 = Double.NaN;
 
      tmpVar = indata.get("A150");
      if( tmpVar != null) {
         try {
             dscode.A150 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A150\".");
         }
      }
      else 
         dscode.A150 = Double.NaN;
 
      tmpVar = indata.get("A151");
      if( tmpVar != null) {
         try {
             dscode.A151 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A151\".");
         }
      }
      else 
         dscode.A151 = Double.NaN;
 
      tmpVar = indata.get("A152");
      if( tmpVar != null) {
         try {
             dscode.A152 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A152\".");
         }
      }
      else 
         dscode.A152 = Double.NaN;
 
      tmpVar = indata.get("A156");
      if( tmpVar != null) {
         try {
             dscode.A156 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A156\".");
         }
      }
      else 
         dscode.A156 = Double.NaN;
 
      tmpVar = indata.get("A157");
      if( tmpVar != null) {
         try {
             dscode.A157 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A157\".");
         }
      }
      else 
         dscode.A157 = Double.NaN;
 
      tmpVar = indata.get("A158");
      if( tmpVar != null) {
         try {
             dscode.A158 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A158\".");
         }
      }
      else 
         dscode.A158 = Double.NaN;
 
      tmpVar = indata.get("A159");
      if( tmpVar != null) {
         try {
             dscode.A159 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A159\".");
         }
      }
      else 
         dscode.A159 = Double.NaN;
 
      tmpVar = indata.get("A16");
      if( tmpVar != null) {
         try {
             dscode.A16 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A16\".");
         }
      }
      else 
         dscode.A16 = Double.NaN;
 
      tmpVar = indata.get("A160");
      if( tmpVar != null) {
         try {
             dscode.A160 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A160\".");
         }
      }
      else 
         dscode.A160 = Double.NaN;
 
      tmpVar = indata.get("A161");
      if( tmpVar != null) {
         try {
             dscode.A161 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A161\".");
         }
      }
      else 
         dscode.A161 = Double.NaN;
 
      tmpVar = indata.get("A165");
      if( tmpVar != null) {
         try {
             dscode.A165 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A165\".");
         }
      }
      else 
         dscode.A165 = Double.NaN;
 
      tmpVar = indata.get("A166");
      if( tmpVar != null) {
         try {
             dscode.A166 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A166\".");
         }
      }
      else 
         dscode.A166 = Double.NaN;
 
      tmpVar = indata.get("A167");
      if( tmpVar != null) {
         try {
             dscode.A167 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A167\".");
         }
      }
      else 
         dscode.A167 = Double.NaN;
 
      tmpVar = indata.get("A168");
      if( tmpVar != null) {
         try {
             dscode.A168 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A168\".");
         }
      }
      else 
         dscode.A168 = Double.NaN;
 
      tmpVar = indata.get("A169");
      if( tmpVar != null) {
         try {
             dscode.A169 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A169\".");
         }
      }
      else 
         dscode.A169 = Double.NaN;
 
      tmpVar = indata.get("A17");
      if( tmpVar != null) {
         try {
             dscode.A17 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A17\".");
         }
      }
      else 
         dscode.A17 = Double.NaN;
 
      tmpVar = indata.get("A170");
      if( tmpVar != null) {
         try {
             dscode.A170 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A170\".");
         }
      }
      else 
         dscode.A170 = Double.NaN;
 
      tmpVar = indata.get("A174");
      if( tmpVar != null) {
         try {
             dscode.A174 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A174\".");
         }
      }
      else 
         dscode.A174 = Double.NaN;
 
      tmpVar = indata.get("A175");
      if( tmpVar != null) {
         try {
             dscode.A175 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A175\".");
         }
      }
      else 
         dscode.A175 = Double.NaN;
 
      tmpVar = indata.get("A176");
      if( tmpVar != null) {
         try {
             dscode.A176 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A176\".");
         }
      }
      else 
         dscode.A176 = Double.NaN;
 
      tmpVar = indata.get("A177");
      if( tmpVar != null) {
         try {
             dscode.A177 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A177\".");
         }
      }
      else 
         dscode.A177 = Double.NaN;
 
      tmpVar = indata.get("A178");
      if( tmpVar != null) {
         try {
             dscode.A178 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A178\".");
         }
      }
      else 
         dscode.A178 = Double.NaN;
 
      tmpVar = indata.get("A179");
      if( tmpVar != null) {
         try {
             dscode.A179 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A179\".");
         }
      }
      else 
         dscode.A179 = Double.NaN;
 
      tmpVar = indata.get("A18");
      if( tmpVar != null) {
         try {
             dscode.A18 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A18\".");
         }
      }
      else 
         dscode.A18 = Double.NaN;
 
      tmpVar = indata.get("A183");
      if( tmpVar != null) {
         try {
             dscode.A183 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A183\".");
         }
      }
      else 
         dscode.A183 = Double.NaN;
 
      tmpVar = indata.get("A184");
      if( tmpVar != null) {
         try {
             dscode.A184 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A184\".");
         }
      }
      else 
         dscode.A184 = Double.NaN;
 
      tmpVar = indata.get("A185");
      if( tmpVar != null) {
         try {
             dscode.A185 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A185\".");
         }
      }
      else 
         dscode.A185 = Double.NaN;
 
      tmpVar = indata.get("A186");
      if( tmpVar != null) {
         try {
             dscode.A186 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A186\".");
         }
      }
      else 
         dscode.A186 = Double.NaN;
 
      tmpVar = indata.get("A187");
      if( tmpVar != null) {
         try {
             dscode.A187 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A187\".");
         }
      }
      else 
         dscode.A187 = Double.NaN;
 
      tmpVar = indata.get("A188");
      if( tmpVar != null) {
         try {
             dscode.A188 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A188\".");
         }
      }
      else 
         dscode.A188 = Double.NaN;
 
      tmpVar = indata.get("A192");
      if( tmpVar != null) {
         try {
             dscode.A192 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A192\".");
         }
      }
      else 
         dscode.A192 = Double.NaN;
 
      tmpVar = indata.get("A193");
      if( tmpVar != null) {
         try {
             dscode.A193 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A193\".");
         }
      }
      else 
         dscode.A193 = Double.NaN;
 
      tmpVar = indata.get("A194");
      if( tmpVar != null) {
         try {
             dscode.A194 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A194\".");
         }
      }
      else 
         dscode.A194 = Double.NaN;
 
      tmpVar = indata.get("A195");
      if( tmpVar != null) {
         try {
             dscode.A195 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A195\".");
         }
      }
      else 
         dscode.A195 = Double.NaN;
 
      tmpVar = indata.get("A196");
      if( tmpVar != null) {
         try {
             dscode.A196 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A196\".");
         }
      }
      else 
         dscode.A196 = Double.NaN;
 
      tmpVar = indata.get("A197");
      if( tmpVar != null) {
         try {
             dscode.A197 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A197\".");
         }
      }
      else 
         dscode.A197 = Double.NaN;
 
      tmpVar = indata.get("A2");
      if( tmpVar != null) {
         try {
             dscode.A2 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A2\".");
         }
      }
      else 
         dscode.A2 = Double.NaN;
 
      tmpVar = indata.get("A210");
      if( tmpVar != null) {
         try {
             dscode.A210 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A210\".");
         }
      }
      else 
         dscode.A210 = Double.NaN;
 
      tmpVar = indata.get("A213");
      if( tmpVar != null) {
         try {
             dscode.A213 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A213\".");
         }
      }
      else 
         dscode.A213 = Double.NaN;
 
      tmpVar = indata.get("A214");
      if( tmpVar != null) {
         try {
             dscode.A214 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A214\".");
         }
      }
      else 
         dscode.A214 = Double.NaN;
 
      tmpVar = indata.get("A219");
      if( tmpVar != null) {
         try {
             dscode.A219 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A219\".");
         }
      }
      else 
         dscode.A219 = Double.NaN;
 
      tmpVar = indata.get("A220");
      if( tmpVar != null) {
         try {
             dscode.A220 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A220\".");
         }
      }
      else 
         dscode.A220 = Double.NaN;
 
      tmpVar = indata.get("A221");
      if( tmpVar != null) {
         try {
             dscode.A221 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A221\".");
         }
      }
      else 
         dscode.A221 = Double.NaN;
 
      tmpVar = indata.get("A228");
      if( tmpVar != null) {
         try {
             dscode.A228 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A228\".");
         }
      }
      else 
         dscode.A228 = Double.NaN;
 
      tmpVar = indata.get("A229");
      if( tmpVar != null) {
         try {
             dscode.A229 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A229\".");
         }
      }
      else 
         dscode.A229 = Double.NaN;
 
      tmpVar = indata.get("A23");
      if( tmpVar != null) {
         try {
             dscode.A23 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A23\".");
         }
      }
      else 
         dscode.A23 = Double.NaN;
 
      tmpVar = indata.get("A267");
      if( tmpVar != null) {
         try {
             dscode.A267 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A267\".");
         }
      }
      else 
         dscode.A267 = Double.NaN;
 
      tmpVar = indata.get("A268");
      if( tmpVar != null) {
         try {
             dscode.A268 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A268\".");
         }
      }
      else 
         dscode.A268 = Double.NaN;
 
      tmpVar = indata.get("A275");
      if( tmpVar != null) {
         try {
             dscode.A275 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A275\".");
         }
      }
      else 
         dscode.A275 = Double.NaN;
 
      tmpVar = indata.get("A3");
      if( tmpVar != null) {
         try {
             dscode.A3 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A3\".");
         }
      }
      else 
         dscode.A3 = Double.NaN;
 
      tmpVar = indata.get("A31");
      if( tmpVar != null) {
         try {
             dscode.A31 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A31\".");
         }
      }
      else 
         dscode.A31 = Double.NaN;
 
      tmpVar = indata.get("A314");
      if( tmpVar != null) {
         try {
             dscode.A314 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A314\".");
         }
      }
      else 
         dscode.A314 = Double.NaN;
 
      tmpVar = indata.get("A316");
      if( tmpVar != null) {
         try {
             dscode.A316 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A316\".");
         }
      }
      else 
         dscode.A316 = Double.NaN;
 
      tmpVar = indata.get("A32");
      if( tmpVar != null) {
         try {
             dscode.A32 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A32\".");
         }
      }
      else 
         dscode.A32 = Double.NaN;
 
      tmpVar = indata.get("A320");
      if( tmpVar != null) {
         try {
             dscode.A320 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A320\".");
         }
      }
      else 
         dscode.A320 = Double.NaN;
 
      tmpVar = indata.get("A321");
      if( tmpVar != null) {
         try {
             dscode.A321 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A321\".");
         }
      }
      else 
         dscode.A321 = Double.NaN;
 
      tmpVar = indata.get("A322");
      if( tmpVar != null) {
         try {
             dscode.A322 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A322\".");
         }
      }
      else 
         dscode.A322 = Double.NaN;
 
      tmpVar = indata.get("A328");
      if( tmpVar != null) {
         try {
             dscode.A328 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A328\".");
         }
      }
      else 
         dscode.A328 = Double.NaN;
 
      tmpVar = indata.get("A329");
      if( tmpVar != null) {
         try {
             dscode.A329 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A329\".");
         }
      }
      else 
         dscode.A329 = Double.NaN;
 
      tmpVar = indata.get("A334");
      if( tmpVar != null) {
         try {
             dscode.A334 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A334\".");
         }
      }
      else 
         dscode.A334 = Double.NaN;
 
      tmpVar = indata.get("A335");
      if( tmpVar != null) {
         try {
             dscode.A335 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A335\".");
         }
      }
      else 
         dscode.A335 = Double.NaN;
 
      tmpVar = indata.get("A34");
      if( tmpVar != null) {
         try {
             dscode.A34 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A34\".");
         }
      }
      else 
         dscode.A34 = Double.NaN;
 
      tmpVar = indata.get("A340");
      if( tmpVar != null) {
         try {
             dscode.A340 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A340\".");
         }
      }
      else 
         dscode.A340 = Double.NaN;
 
      tmpVar = indata.get("A341");
      if( tmpVar != null) {
         try {
             dscode.A341 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A341\".");
         }
      }
      else 
         dscode.A341 = Double.NaN;
 
      tmpVar = indata.get("A346");
      if( tmpVar != null) {
         try {
             dscode.A346 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A346\".");
         }
      }
      else 
         dscode.A346 = Double.NaN;
 
      tmpVar = indata.get("A347");
      if( tmpVar != null) {
         try {
             dscode.A347 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A347\".");
         }
      }
      else 
         dscode.A347 = Double.NaN;
 
      tmpVar = indata.get("A35");
      if( tmpVar != null) {
         try {
             dscode.A35 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A35\".");
         }
      }
      else 
         dscode.A35 = Double.NaN;
 
      tmpVar = indata.get("A352");
      if( tmpVar != null) {
         try {
             dscode.A352 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A352\".");
         }
      }
      else 
         dscode.A352 = Double.NaN;
 
      tmpVar = indata.get("A353");
      if( tmpVar != null) {
         try {
             dscode.A353 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A353\".");
         }
      }
      else 
         dscode.A353 = Double.NaN;
 
      tmpVar = indata.get("A358");
      if( tmpVar != null) {
         try {
             dscode.A358 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A358\".");
         }
      }
      else 
         dscode.A358 = Double.NaN;
 
      tmpVar = indata.get("A359");
      if( tmpVar != null) {
         try {
             dscode.A359 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A359\".");
         }
      }
      else 
         dscode.A359 = Double.NaN;
 
      tmpVar = indata.get("A364");
      if( tmpVar != null) {
         try {
             dscode.A364 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A364\".");
         }
      }
      else 
         dscode.A364 = Double.NaN;
 
      tmpVar = indata.get("A365");
      if( tmpVar != null) {
         try {
             dscode.A365 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A365\".");
         }
      }
      else 
         dscode.A365 = Double.NaN;
 
      tmpVar = indata.get("A37");
      if( tmpVar != null) {
         try {
             dscode.A37 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A37\".");
         }
      }
      else 
         dscode.A37 = Double.NaN;
 
      tmpVar = indata.get("A370");
      if( tmpVar != null) {
         try {
             dscode.A370 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A370\".");
         }
      }
      else 
         dscode.A370 = Double.NaN;
 
      tmpVar = indata.get("A371");
      if( tmpVar != null) {
         try {
             dscode.A371 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A371\".");
         }
      }
      else 
         dscode.A371 = Double.NaN;
 
      tmpVar = indata.get("A387");
      if( tmpVar != null) {
         try {
             dscode.A387 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A387\".");
         }
      }
      else 
         dscode.A387 = Double.NaN;
 
      tmpVar = indata.get("A39");
      if( tmpVar != null) {
         try {
             dscode.A39 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A39\".");
         }
      }
      else 
         dscode.A39 = Double.NaN;
 
      tmpVar = indata.get("A391");
      if( tmpVar != null) {
         try {
             dscode.A391 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A391\".");
         }
      }
      else 
         dscode.A391 = Double.NaN;
 
      tmpVar = indata.get("A399");
      if( tmpVar != null) {
         try {
             dscode.A399 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A399\".");
         }
      }
      else 
         dscode.A399 = Double.NaN;
 
      tmpVar = indata.get("A4");
      if( tmpVar != null) {
         try {
             dscode.A4 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A4\".");
         }
      }
      else 
         dscode.A4 = Double.NaN;
 
      tmpVar = indata.get("A40");
      if( tmpVar != null) {
         try {
             dscode.A40 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A40\".");
         }
      }
      else 
         dscode.A40 = Double.NaN;
 
      tmpVar = indata.get("A400");
      if( tmpVar != null) {
         try {
             dscode.A400 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A400\".");
         }
      }
      else 
         dscode.A400 = Double.NaN;
 
      tmpVar = indata.get("A403");
      if( tmpVar != null) {
         try {
             dscode.A403 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A403\".");
         }
      }
      else 
         dscode.A403 = Double.NaN;
 
      tmpVar = indata.get("A404");
      if( tmpVar != null) {
         try {
             dscode.A404 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A404\".");
         }
      }
      else 
         dscode.A404 = Double.NaN;
 
      tmpVar = indata.get("A405");
      if( tmpVar != null) {
         try {
             dscode.A405 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A405\".");
         }
      }
      else 
         dscode.A405 = Double.NaN;
 
      tmpVar = indata.get("A406");
      if( tmpVar != null) {
         try {
             dscode.A406 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A406\".");
         }
      }
      else 
         dscode.A406 = Double.NaN;
 
      tmpVar = indata.get("A407");
      if( tmpVar != null) {
         try {
             dscode.A407 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A407\".");
         }
      }
      else 
         dscode.A407 = Double.NaN;
 
      tmpVar = indata.get("A408");
      if( tmpVar != null) {
         try {
             dscode.A408 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A408\".");
         }
      }
      else 
         dscode.A408 = Double.NaN;
 
      tmpVar = indata.get("A409");
      if( tmpVar != null) {
         try {
             dscode.A409 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A409\".");
         }
      }
      else 
         dscode.A409 = Double.NaN;
 
      tmpVar = indata.get("A41");
      if( tmpVar != null) {
         try {
             dscode.A41 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A41\".");
         }
      }
      else 
         dscode.A41 = Double.NaN;
 
      tmpVar = indata.get("A410");
      if( tmpVar != null) {
         try {
             dscode.A410 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A410\".");
         }
      }
      else 
         dscode.A410 = Double.NaN;
 
      tmpVar = indata.get("A411");
      if( tmpVar != null) {
         try {
             dscode.A411 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A411\".");
         }
      }
      else 
         dscode.A411 = Double.NaN;
 
      tmpVar = indata.get("A412");
      if( tmpVar != null) {
         try {
             dscode.A412 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A412\".");
         }
      }
      else 
         dscode.A412 = Double.NaN;
 
      tmpVar = indata.get("A413");
      if( tmpVar != null) {
         try {
             dscode.A413 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A413\".");
         }
      }
      else 
         dscode.A413 = Double.NaN;
 
      tmpVar = indata.get("A414");
      if( tmpVar != null) {
         try {
             dscode.A414 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A414\".");
         }
      }
      else 
         dscode.A414 = Double.NaN;
 
      tmpVar = indata.get("A418");
      if( tmpVar != null) {
         try {
             dscode.A418 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A418\".");
         }
      }
      else 
         dscode.A418 = Double.NaN;
 
      tmpVar = indata.get("A419");
      if( tmpVar != null) {
         try {
             dscode.A419 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A419\".");
         }
      }
      else 
         dscode.A419 = Double.NaN;
 
      tmpVar = indata.get("A42");
      if( tmpVar != null) {
         try {
             dscode.A42 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A42\".");
         }
      }
      else 
         dscode.A42 = Double.NaN;
 
      tmpVar = indata.get("A421");
      if( tmpVar != null) {
         try {
             dscode.A421 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A421\".");
         }
      }
      else 
         dscode.A421 = Double.NaN;
 
      tmpVar = indata.get("A422");
      if( tmpVar != null) {
         try {
             dscode.A422 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A422\".");
         }
      }
      else 
         dscode.A422 = Double.NaN;
 
      tmpVar = indata.get("A423");
      if( tmpVar != null) {
         try {
             dscode.A423 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A423\".");
         }
      }
      else 
         dscode.A423 = Double.NaN;
 
      tmpVar = indata.get("A424");
      if( tmpVar != null) {
         try {
             dscode.A424 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A424\".");
         }
      }
      else 
         dscode.A424 = Double.NaN;
 
      tmpVar = indata.get("A425");
      if( tmpVar != null) {
         try {
             dscode.A425 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A425\".");
         }
      }
      else 
         dscode.A425 = Double.NaN;
 
      tmpVar = indata.get("A426");
      if( tmpVar != null) {
         try {
             dscode.A426 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A426\".");
         }
      }
      else 
         dscode.A426 = Double.NaN;
 
      tmpVar = indata.get("A427");
      if( tmpVar != null) {
         try {
             dscode.A427 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A427\".");
         }
      }
      else 
         dscode.A427 = Double.NaN;
 
      tmpVar = indata.get("A428");
      if( tmpVar != null) {
         try {
             dscode.A428 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A428\".");
         }
      }
      else 
         dscode.A428 = Double.NaN;
 
      tmpVar = indata.get("A429");
      if( tmpVar != null) {
         try {
             dscode.A429 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A429\".");
         }
      }
      else 
         dscode.A429 = Double.NaN;
 
      tmpVar = indata.get("A43");
      if( tmpVar != null) {
         try {
             dscode.A43 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A43\".");
         }
      }
      else 
         dscode.A43 = Double.NaN;
 
      tmpVar = indata.get("A455");
      if( tmpVar != null) {
         try {
             dscode.A455 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A455\".");
         }
      }
      else 
         dscode.A455 = Double.NaN;
 
      tmpVar = indata.get("A459");
      if( tmpVar != null) {
         try {
             dscode.A459 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A459\".");
         }
      }
      else 
         dscode.A459 = Double.NaN;
 
      tmpVar = indata.get("A46");
      if( tmpVar != null) {
         try {
             dscode.A46 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A46\".");
         }
      }
      else 
         dscode.A46 = Double.NaN;
 
      tmpVar = indata.get("A460");
      if( tmpVar != null) {
         try {
             dscode.A460 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A460\".");
         }
      }
      else 
         dscode.A460 = Double.NaN;
 
      tmpVar = indata.get("A461");
      if( tmpVar != null) {
         try {
             dscode.A461 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A461\".");
         }
      }
      else 
         dscode.A461 = Double.NaN;
 
      tmpVar = indata.get("A462");
      if( tmpVar != null) {
         try {
             dscode.A462 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A462\".");
         }
      }
      else 
         dscode.A462 = Double.NaN;
 
      tmpVar = indata.get("A463");
      if( tmpVar != null) {
         try {
             dscode.A463 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A463\".");
         }
      }
      else 
         dscode.A463 = Double.NaN;
 
      tmpVar = indata.get("A464");
      if( tmpVar != null) {
         try {
             dscode.A464 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A464\".");
         }
      }
      else 
         dscode.A464 = Double.NaN;
 
      tmpVar = indata.get("A465");
      if( tmpVar != null) {
         try {
             dscode.A465 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A465\".");
         }
      }
      else 
         dscode.A465 = Double.NaN;
 
      tmpVar = indata.get("A466");
      if( tmpVar != null) {
         try {
             dscode.A466 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A466\".");
         }
      }
      else 
         dscode.A466 = Double.NaN;
 
      tmpVar = indata.get("A467");
      if( tmpVar != null) {
         try {
             dscode.A467 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A467\".");
         }
      }
      else 
         dscode.A467 = Double.NaN;
 
      tmpVar = indata.get("A468");
      if( tmpVar != null) {
         try {
             dscode.A468 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A468\".");
         }
      }
      else 
         dscode.A468 = Double.NaN;
 
      tmpVar = indata.get("A470");
      if( tmpVar != null) {
         try {
             dscode.A470 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A470\".");
         }
      }
      else 
         dscode.A470 = Double.NaN;
 
      tmpVar = indata.get("A471");
      if( tmpVar != null) {
         try {
             dscode.A471 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A471\".");
         }
      }
      else 
         dscode.A471 = Double.NaN;
 
      tmpVar = indata.get("A472");
      if( tmpVar != null) {
         try {
             dscode.A472 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A472\".");
         }
      }
      else 
         dscode.A472 = Double.NaN;
 
      tmpVar = indata.get("A473");
      if( tmpVar != null) {
         try {
             dscode.A473 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A473\".");
         }
      }
      else 
         dscode.A473 = Double.NaN;
 
      tmpVar = indata.get("A474");
      if( tmpVar != null) {
         try {
             dscode.A474 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A474\".");
         }
      }
      else 
         dscode.A474 = Double.NaN;
 
      tmpVar = indata.get("A475");
      if( tmpVar != null) {
         try {
             dscode.A475 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A475\".");
         }
      }
      else 
         dscode.A475 = Double.NaN;
 
      tmpVar = indata.get("A476");
      if( tmpVar != null) {
         try {
             dscode.A476 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A476\".");
         }
      }
      else 
         dscode.A476 = Double.NaN;
 
      tmpVar = indata.get("A477");
      if( tmpVar != null) {
         try {
             dscode.A477 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A477\".");
         }
      }
      else 
         dscode.A477 = Double.NaN;
 
      tmpVar = indata.get("A478");
      if( tmpVar != null) {
         try {
             dscode.A478 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A478\".");
         }
      }
      else 
         dscode.A478 = Double.NaN;
 
      tmpVar = indata.get("A479");
      if( tmpVar != null) {
         try {
             dscode.A479 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A479\".");
         }
      }
      else 
         dscode.A479 = Double.NaN;
 
      tmpVar = indata.get("A480");
      if( tmpVar != null) {
         try {
             dscode.A480 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A480\".");
         }
      }
      else 
         dscode.A480 = Double.NaN;
 
      tmpVar = indata.get("A481");
      if( tmpVar != null) {
         try {
             dscode.A481 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A481\".");
         }
      }
      else 
         dscode.A481 = Double.NaN;
 
      tmpVar = indata.get("A482");
      if( tmpVar != null) {
         try {
             dscode.A482 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A482\".");
         }
      }
      else 
         dscode.A482 = Double.NaN;
 
      tmpVar = indata.get("A483");
      if( tmpVar != null) {
         try {
             dscode.A483 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A483\".");
         }
      }
      else 
         dscode.A483 = Double.NaN;
 
      tmpVar = indata.get("A484");
      if( tmpVar != null) {
         try {
             dscode.A484 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A484\".");
         }
      }
      else 
         dscode.A484 = Double.NaN;
 
      tmpVar = indata.get("A485");
      if( tmpVar != null) {
         try {
             dscode.A485 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A485\".");
         }
      }
      else 
         dscode.A485 = Double.NaN;
 
      tmpVar = indata.get("A486");
      if( tmpVar != null) {
         try {
             dscode.A486 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A486\".");
         }
      }
      else 
         dscode.A486 = Double.NaN;
 
      tmpVar = indata.get("A487");
      if( tmpVar != null) {
         try {
             dscode.A487 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A487\".");
         }
      }
      else 
         dscode.A487 = Double.NaN;
 
      tmpVar = indata.get("A488");
      if( tmpVar != null) {
         try {
             dscode.A488 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A488\".");
         }
      }
      else 
         dscode.A488 = Double.NaN;
 
      tmpVar = indata.get("A489");
      if( tmpVar != null) {
         try {
             dscode.A489 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A489\".");
         }
      }
      else 
         dscode.A489 = Double.NaN;
 
      tmpVar = indata.get("A490");
      if( tmpVar != null) {
         try {
             dscode.A490 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A490\".");
         }
      }
      else 
         dscode.A490 = Double.NaN;
 
      tmpVar = indata.get("A491");
      if( tmpVar != null) {
         try {
             dscode.A491 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A491\".");
         }
      }
      else 
         dscode.A491 = Double.NaN;
 
      tmpVar = indata.get("A492");
      if( tmpVar != null) {
         try {
             dscode.A492 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A492\".");
         }
      }
      else 
         dscode.A492 = Double.NaN;
 
      tmpVar = indata.get("A493");
      if( tmpVar != null) {
         try {
             dscode.A493 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A493\".");
         }
      }
      else 
         dscode.A493 = Double.NaN;
 
      tmpVar = indata.get("A494");
      if( tmpVar != null) {
         try {
             dscode.A494 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A494\".");
         }
      }
      else 
         dscode.A494 = Double.NaN;
 
      tmpVar = indata.get("A495");
      if( tmpVar != null) {
         try {
             dscode.A495 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A495\".");
         }
      }
      else 
         dscode.A495 = Double.NaN;
 
      tmpVar = indata.get("A496");
      if( tmpVar != null) {
         try {
             dscode.A496 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A496\".");
         }
      }
      else 
         dscode.A496 = Double.NaN;
 
      tmpVar = indata.get("A497");
      if( tmpVar != null) {
         try {
             dscode.A497 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A497\".");
         }
      }
      else 
         dscode.A497 = Double.NaN;
 
      tmpVar = indata.get("A498");
      if( tmpVar != null) {
         try {
             dscode.A498 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A498\".");
         }
      }
      else 
         dscode.A498 = Double.NaN;
 
      tmpVar = indata.get("A499");
      if( tmpVar != null) {
         try {
             dscode.A499 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A499\".");
         }
      }
      else 
         dscode.A499 = Double.NaN;
 
      tmpVar = indata.get("A500");
      if( tmpVar != null) {
         try {
             dscode.A500 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A500\".");
         }
      }
      else 
         dscode.A500 = Double.NaN;
 
      tmpVar = indata.get("A501");
      if( tmpVar != null) {
         try {
             dscode.A501 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A501\".");
         }
      }
      else 
         dscode.A501 = Double.NaN;
 
      tmpVar = indata.get("A502");
      if( tmpVar != null) {
         try {
             dscode.A502 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A502\".");
         }
      }
      else 
         dscode.A502 = Double.NaN;
 
      tmpVar = indata.get("A503");
      if( tmpVar != null) {
         try {
             dscode.A503 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A503\".");
         }
      }
      else 
         dscode.A503 = Double.NaN;
 
      tmpVar = indata.get("A504");
      if( tmpVar != null) {
         try {
             dscode.A504 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A504\".");
         }
      }
      else 
         dscode.A504 = Double.NaN;
 
      tmpVar = indata.get("A505");
      if( tmpVar != null) {
         try {
             dscode.A505 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A505\".");
         }
      }
      else 
         dscode.A505 = Double.NaN;
 
      tmpVar = indata.get("A506");
      if( tmpVar != null) {
         try {
             dscode.A506 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A506\".");
         }
      }
      else 
         dscode.A506 = Double.NaN;
 
      tmpVar = indata.get("A507");
      if( tmpVar != null) {
         try {
             dscode.A507 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A507\".");
         }
      }
      else 
         dscode.A507 = Double.NaN;
 
      tmpVar = indata.get("A508");
      if( tmpVar != null) {
         try {
             dscode.A508 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A508\".");
         }
      }
      else 
         dscode.A508 = Double.NaN;
 
      tmpVar = indata.get("A509");
      if( tmpVar != null) {
         try {
             dscode.A509 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A509\".");
         }
      }
      else 
         dscode.A509 = Double.NaN;
 
      tmpVar = indata.get("A510");
      if( tmpVar != null) {
         try {
             dscode.A510 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A510\".");
         }
      }
      else 
         dscode.A510 = Double.NaN;
 
      tmpVar = indata.get("A511");
      if( tmpVar != null) {
         try {
             dscode.A511 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A511\".");
         }
      }
      else 
         dscode.A511 = Double.NaN;
 
      tmpVar = indata.get("A512");
      if( tmpVar != null) {
         try {
             dscode.A512 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A512\".");
         }
      }
      else 
         dscode.A512 = Double.NaN;
 
      tmpVar = indata.get("A513");
      if( tmpVar != null) {
         try {
             dscode.A513 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A513\".");
         }
      }
      else 
         dscode.A513 = Double.NaN;
 
      tmpVar = indata.get("A514");
      if( tmpVar != null) {
         try {
             dscode.A514 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A514\".");
         }
      }
      else 
         dscode.A514 = Double.NaN;
 
      tmpVar = indata.get("A517");
      if( tmpVar != null) {
         try {
             dscode.A517 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A517\".");
         }
      }
      else 
         dscode.A517 = Double.NaN;
 
      tmpVar = indata.get("A519");
      if( tmpVar != null) {
         try {
             dscode.A519 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A519\".");
         }
      }
      else 
         dscode.A519 = Double.NaN;
 
      tmpVar = indata.get("A520");
      if( tmpVar != null) {
         try {
             dscode.A520 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A520\".");
         }
      }
      else 
         dscode.A520 = Double.NaN;
 
      tmpVar = indata.get("A534");
      if( tmpVar != null) {
         try {
             dscode.A534 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A534\".");
         }
      }
      else 
         dscode.A534 = Double.NaN;
 
      tmpVar = indata.get("A535");
      if( tmpVar != null) {
         try {
             dscode.A535 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A535\".");
         }
      }
      else 
         dscode.A535 = Double.NaN;
 
      tmpVar = indata.get("A536");
      if( tmpVar != null) {
         try {
             dscode.A536 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A536\".");
         }
      }
      else 
         dscode.A536 = Double.NaN;
 
      tmpVar = indata.get("A537");
      if( tmpVar != null) {
         try {
             dscode.A537 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A537\".");
         }
      }
      else 
         dscode.A537 = Double.NaN;
 
      tmpVar = indata.get("A538");
      if( tmpVar != null) {
         try {
             dscode.A538 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A538\".");
         }
      }
      else 
         dscode.A538 = Double.NaN;
 
      tmpVar = indata.get("A539");
      if( tmpVar != null) {
         try {
             dscode.A539 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A539\".");
         }
      }
      else 
         dscode.A539 = Double.NaN;
 
      tmpVar = indata.get("A540");
      if( tmpVar != null) {
         try {
             dscode.A540 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A540\".");
         }
      }
      else 
         dscode.A540 = Double.NaN;
 
      tmpVar = indata.get("A541");
      if( tmpVar != null) {
         try {
             dscode.A541 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A541\".");
         }
      }
      else 
         dscode.A541 = Double.NaN;
 
      tmpVar = indata.get("A542");
      if( tmpVar != null) {
         try {
             dscode.A542 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A542\".");
         }
      }
      else 
         dscode.A542 = Double.NaN;
 
      tmpVar = indata.get("A543");
      if( tmpVar != null) {
         try {
             dscode.A543 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A543\".");
         }
      }
      else 
         dscode.A543 = Double.NaN;
 
      tmpVar = indata.get("A544");
      if( tmpVar != null) {
         try {
             dscode.A544 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A544\".");
         }
      }
      else 
         dscode.A544 = Double.NaN;
 
      tmpVar = indata.get("A545");
      if( tmpVar != null) {
         try {
             dscode.A545 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A545\".");
         }
      }
      else 
         dscode.A545 = Double.NaN;
 
      tmpVar = indata.get("A546");
      if( tmpVar != null) {
         try {
             dscode.A546 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A546\".");
         }
      }
      else 
         dscode.A546 = Double.NaN;
 
      tmpVar = indata.get("A547");
      if( tmpVar != null) {
         try {
             dscode.A547 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A547\".");
         }
      }
      else 
         dscode.A547 = Double.NaN;
 
      tmpVar = indata.get("A548");
      if( tmpVar != null) {
         try {
             dscode.A548 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A548\".");
         }
      }
      else 
         dscode.A548 = Double.NaN;
 
      tmpVar = indata.get("A549");
      if( tmpVar != null) {
         try {
             dscode.A549 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A549\".");
         }
      }
      else 
         dscode.A549 = Double.NaN;
 
      tmpVar = indata.get("A558");
      if( tmpVar != null) {
         try {
             dscode.A558 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A558\".");
         }
      }
      else 
         dscode.A558 = Double.NaN;
 
      tmpVar = indata.get("A569");
      if( tmpVar != null) {
         try {
             dscode.A569 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A569\".");
         }
      }
      else 
         dscode.A569 = Double.NaN;
 
      tmpVar = indata.get("A581");
      if( tmpVar != null) {
         try {
             dscode.A581 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A581\".");
         }
      }
      else 
         dscode.A581 = Double.NaN;
 
      tmpVar = indata.get("A582");
      if( tmpVar != null) {
         try {
             dscode.A582 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A582\".");
         }
      }
      else 
         dscode.A582 = Double.NaN;
 
      tmpVar = indata.get("A594");
      if( tmpVar != null) {
         try {
             dscode.A594 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A594\".");
         }
      }
      else 
         dscode.A594 = Double.NaN;
 
      tmpVar = indata.get("A605");
      if( tmpVar != null) {
         try {
             dscode.A605 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A605\".");
         }
      }
      else 
         dscode.A605 = Double.NaN;
 
      tmpVar = indata.get("A622");
      if( tmpVar != null) {
         try {
             dscode.A622 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A622\".");
         }
      }
      else 
         dscode.A622 = Double.NaN;
 
      tmpVar = indata.get("A623");
      if( tmpVar != null) {
         try {
             dscode.A623 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A623\".");
         }
      }
      else 
         dscode.A623 = Double.NaN;
 
      tmpVar = indata.get("A625");
      if( tmpVar != null) {
         try {
             dscode.A625 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A625\".");
         }
      }
      else 
         dscode.A625 = Double.NaN;
 
      tmpVar = indata.get("A63");
      if( tmpVar != null) {
         try {
             dscode.A63 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A63\".");
         }
      }
      else 
         dscode.A63 = Double.NaN;
 
      tmpVar = indata.get("A65");
      if( tmpVar != null) {
         try {
             dscode.A65 = ((Double)tmpVar).doubleValue();
         } catch (Exception ex) {
             throw new JscoreException("Invalid input data type for Double \"A65\".");
         }
      }
      else 
         dscode.A65 = Double.NaN;
 
      dscode.EM_CLASSIFICATION = " ";
      dscode.EM_EVENTPROBABILITY = Double.NaN;
      dscode.EM_PROBABILITY = Double.NaN;
      dscode.I_FLAG = " ";
      dscode.P_FLAG0 = Double.NaN;
      dscode.P_FLAG1 = Double.NaN;
      dscode.U_FLAG = Double.NaN;
      dscode._WARN_ = " ";
 
      dscode.run();
 
      outputVariables.put("EM_CLASSIFICATION",((Object)dscode.EM_CLASSIFICATION));
      outputVariables.put("EM_EVENTPROBABILITY",((Object)new Double(dscode.EM_EVENTPROBABILITY)));
      outputVariables.put("EM_PROBABILITY",((Object)new Double(dscode.EM_PROBABILITY)));
      outputVariables.put("I_FLAG",((Object)dscode.I_FLAG));
      outputVariables.put("P_FLAG0",((Object)new Double(dscode.P_FLAG0)));
      outputVariables.put("P_FLAG1",((Object)new Double(dscode.P_FLAG1)));
      outputVariables.put("U_FLAG",((Object)new Double(dscode.U_FLAG)));
      outputVariables.put("_WARN_",((Object)dscode._WARN_));
      return outputVariables;
   }
 
} // end class Score
