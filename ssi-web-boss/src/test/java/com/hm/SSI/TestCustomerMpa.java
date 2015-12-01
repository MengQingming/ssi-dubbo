package com.hm.SSI;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hm.SSI.manager.mysql.MiUserManager;



public class TestCustomerMpa {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");  
		
		long startTimeNs = System.nanoTime();
		long startTimeMs = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			MiUserManager mUserManagerImpl =  (MiUserManager) context.getBean("muserManagerImpl");
			try {
				mUserManagerImpl.selectAllUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTimeNs = System.nanoTime();
		long endTimeMs = System.currentTimeMillis();
	    context.stop();
	    System.out.println("----测试Dubbo负载调用----");
		System.out.println("循环 10000 次调用，计算服务的调用次数，以及调用用时");
	    System.out.println("共用时:"+ (endTimeNs-startTimeNs)/1000000 +"ms");
	    Double doubleNs = new Double(endTimeNs-startTimeNs);
	    System.out.println("单个用时:"+ new Double(doubleNs/1000000/100) +"ms");
	    System.out.println("共用时:"+ (endTimeMs-startTimeMs) +"ms");
	    Double doubleMs = new Double(endTimeMs-startTimeMs);
	    System.out.println("单个用时:"+ new Double(doubleMs/100) +"ms");
	    
	    System.out.println("共用时:"+ (endTimeMs-startTimeMs)/1000 +"m");
	    System.out.println("单个用时:"+ new Double(doubleMs/1000/100) +"m");
	}
}
