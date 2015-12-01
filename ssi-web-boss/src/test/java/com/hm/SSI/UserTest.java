package com.hm.SSI;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.StringDecoder;
import org.aspectj.apache.bcel.generic.NEW;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


@SuppressWarnings({"unchecked", "rawtypes","unused","deprecation"})
public class UserTest {

	@Test
	public void test1(){
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Map map = new HashMap();
			String url = UrlUtils.theCustomUrl("","80","user", "getAllUser", map);
			UrlUtils.runUrl(url);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("共用时:"+(endTime-startTime));
	}
	
	
}
