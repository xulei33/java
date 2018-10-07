package shorturl;

import org.junit.Test;
import org.xulei.url.JsonUtils;
import org.xulei.url.Url;

public class AppTest {

	@Test
	public void test() {
		Url url=new Url();
		url.setCode("111111");
		url.setCustId("222");
		try {
			String json =JsonUtils.mapper.writeValueAsString(url);
			System.out.println(json);
			Url url2=JsonUtils.mapper.readValue(json, Url.class);
			System.out.println(url2.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
