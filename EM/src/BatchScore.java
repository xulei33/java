import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.sas.analytics.eminer.jscore.util.Jscore;
import com.sas.analytics.eminer.jscore.util.JscoreException;

/**
 * 读取CSV文件数据，调用评分模型，结果写入CSV
 */

/**
 * @author Lei
 *
 */
public class BatchScore {

	public static ArrayList<Map<String, Object>> readCSV(String csvFilePath) {

		ArrayList<Map<String, Object>> obs = new ArrayList<Map<String, Object>>();
		ArrayList<String[]> csvFileList = new ArrayList<String[]>();

		try {

			CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));
			reader.readHeaders();
			String[] headers = reader.getHeaders();

			while (reader.readRecord()) {
//				System.out.println(reader.getRawRecord());
				csvFileList.add(reader.getValues());
			}

			reader.close();


			for (int row = 0; row < csvFileList.size(); row++) {
				Map<String, Object> map = new HashMap<String, Object>(2000);
				String[] val = csvFileList.get(row);
				map.put("ID", val[0]);
				for (int i = 1; i < headers.length; i++) {
					String col=headers[i];
					if(col.startsWith("_")) {
						map.put(headers[i], val[i]);
					}else {
						map.put(headers[i], Double.valueOf(val[i]));
					}
				}
				obs.add(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "ABT.csv";
		String rstFilePath = "rst.csv";
		String pkg = "eminer.user.Score";

		if (args.length == 0) {
			System.out.println("使用评分模型eminer.user.Score对文件:" + filePath + " 进行评分,结果保存在:" + rstFilePath);
		} else if (args.length == 3) {
			pkg = args[0];
			filePath = args[1];
			rstFilePath = args[2];
		} else {
			System.out.println("程序使用方式为: java -jar BatchScore.jar 模型package 样本文件路径 评分结果路径");
			System.out.println("如:java -jar BatchScore.jar eminer.user.Score D://tmp//ABT.csv rst.csv");
			System.exit(0);
		}

		Class<Jscore> clz;
		Jscore jsb = null;

		try {
			clz = (Class<Jscore>) Class.forName(pkg + ".Score");
			jsb = clz.newInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		ArrayList<Map<String, Object>> obs = readCSV(filePath);
		ArrayList<String[]> rsts = new ArrayList<String[]>();

		long start = System.currentTimeMillis();
		System.out.println("开始对数据文件" + filePath + "进行模型计算,开始时间:" + start);

		for (Map<String, Object> ob : obs) {
			try {
				Map outdata = jsb.score(ob);
				// process scoring output
//				System.out.println(">> First observation...");
//				System.out.println("EM_CLASSIFICATION = " + (String) outdata.get("EM_CLASSIFICATION"));
//				System.out.println("EM_EVENTPROBABILITY = " + (Double) outdata.get("EM_EVENTPROBABILITY"));
//				System.out.println("EM_PROBABILITY = " + (Double) outdata.get("EM_PROBABILITY"));
//				System.out.println("_WARN_ = " + (String) outdata.get("_WARN_"));

				String[] rst = { (String) ob.get("ID"), String.valueOf(outdata.get("EM_CLASSIFICATION")),
						String.valueOf(outdata.get("EM_EVENTPROBABILITY")),
						String.valueOf(outdata.get("EM_PROBABILITY")), String.valueOf(outdata.get("_WARN_")) };
				rsts.add(rst);
			} catch (JscoreException e) {
				System.out.println(
						"ERROR Data:===================================================================================");
				System.out.println(ob.toString());
				e.printStackTrace();
				System.out
						.println("===================================================================================");
			}
		}
		long time = (System.currentTimeMillis() - start) / 1000;
		System.out.println("评分完成,耗时" + time + "秒,开始保存评分结果");
		writeCSV(rsts, rstFilePath);
		System.out.println("评分结果已经写入" + rstFilePath);
	}

	public static void writeCSV(ArrayList<String[]> rsts, String rstFilePath) {

		try {

			CsvWriter csvWriter = new CsvWriter(rstFilePath, ',', Charset.forName("UTF-8"));

			String[] csvHeaders = { "ID", "EM_CLASSIFICATION", "EM_EVENTPROBABILITY", "EM_PROBABILITY", "_WARN_" };
			csvWriter.writeRecord(csvHeaders);

			for (String[] rst : rsts) {
				csvWriter.writeRecord(rst);
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
