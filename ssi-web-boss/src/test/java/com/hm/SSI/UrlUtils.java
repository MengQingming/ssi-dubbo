package com.hm.SSI;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

/** 
 * <pre>
 * 类名: UrlUrils 
 * 作用: TODO(这里用一句话描述这个类的作用) 
 * 作者: yanpengjie 
 * 日期: 2015年3月23日 上午11:47:52 
 * 版本: V2.0
 * </pre>
 **/

@SuppressWarnings({ "unchecked", "rawtypes" })

public class UrlUtils {
	
	static final String ABOUTUS = "aboutUs";
	static final String ALIPAY = "alipay";
	static final String ARTICLE = "article";
	static final String BANNER = "banner";
	static final String BRAND = "brand";
	static final String CART = "cart";
	static final String COMMENT = "comment";
	static final String COUPONS = "coupons";
	static final String AREA = "area";
	static final String LOGISTICS = "logistics";
	static final String MAIN = "Main";
	static final String ORDER = "order";
	static final String PAYMENTS = "payments";
	static final String PRODUCT = "product";
	static final String SCREEN = "screen";
	static final String UNIONPAY = "unionpay";
	static final String USER = "user";
	static final String VERSION = "version";
	static final String TESTIP = "10.0.129.59";
	static final String CSPOINT = "8093";
	static final String KFPOINT = "8092";
	
	static String projectName="ssi-web-boss";
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * <pre>
	 * 方法名: theCustomUrlOther
	 * 作用: 自定义其他特殊URL ,比如网站地址
	 * @param url 网址,如果为""或null,默认127.0.0.1 即localhost
	 * @param parentPackage 执行的方法所在的包路径 如:cart 在UrlUtil类内有对应字段可选
	 * @param method 执行的方法   如: getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    public static String theCustomUrlOther(String url,String parentPackage,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(url)){
    		url = getLocalIP();
    	}
    	
    	String s1 = "http://";
    	String s2 = "/services/"+parentPackage+"/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String sdt = s1+url+s2+params;
		return sdt;
    }
    
	/**
	 * <pre>
	 * 方法名: theCustomUrl
	 * 作用: 针对所有包自定义URL
	 * @param ip ip地址,如果为""或null,默认127.0.0.1 即localhost
	 * @param point 端口,,如果为""或null,默认80端口
	 * @param parentPackage 执行的方法所在的包路径 如:cart 在UrlUtil类内有对应字段可选
	 * @param method 执行的方法 如:getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    public static String theCustomUrl(String ip,String point,String parentPackage,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(ip)){
    		ip = getLocalIP();
    	}
    	if(StringUtils.isBlank(point)){
    		point = "";
    	}else{
    		point = ":"+point;
    	}
    	String s1 = "http://";
    	String s2 = "/"+projectName+"/"+parentPackage+"/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String url = s1+ip+point+s2+params;
		return url;
    }
    
    /**
	 * <pre>
	 * 方法名: theCustomUrlForMain
	 * 作用: 针对main包自定义URL
	 * @param ip ip地址,如果为""或null,默认127.0.0.1 即localhost
	 * @param point 端口,,如果为""或null,默认80端口
	 * @param method 执行的方法 如 getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    @Deprecated
    public static String theCustomUrlForMain(String ip,String point,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(ip)){
    		ip = getLocalIP();
    	}
    	if(StringUtils.isBlank(point)){
    		point = "";
    	}else{
    		point = ":"+point;
    	}
    	String s1 = "http://";
    	String s2 = "/"+projectName+"/services/Main/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String url = s1+ip+point+s2+params;
		return url;
    }
    

    /**
	 * <pre>
	 * 方法名: theCustomUrlForProduct
	 * 作用: 针对main包自定义URL
	 * @param ip ip地址,如果为""或null,默认127.0.0.1 即localhost
	 * @param point 端口,,如果为""或null,默认80端口
	 * @param method 执行的方法 如 getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    @Deprecated
    public static String theCustomUrlForProduct(String ip,String point,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(ip)){
    		ip = getLocalIP();
    	}
    	if(StringUtils.isBlank(point)){
    		point = "";
    	}else{
    		point = ":"+point;
    	}
    	String s1 = "http://";
    	String s2 = "/"+projectName+"/services/product/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String url = s1+ip+point+s2+params;
		return url;
    }
    
    /**
	 * <pre>
	 * 方法名: theCustomUrlForOrder
	 * 作用: 针对Order包自定义URL
	 * @param ip ip地址,如果为""或null,默认127.0.0.1 即localhost
	 * @param point 端口,,如果为""或null,默认80端口
	 * @param method 执行的方法 如 getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    @Deprecated
    public static String theCustomUrlForOrder(String ip,String point,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(ip)){
    		ip = getLocalIP();
    	}
    	if(StringUtils.isBlank(point)){
    		point = "";
    	}else{
    		point = ":"+point;
    	}
    	String s1 = "http://";
    	String s2 = "/"+projectName+"/services/order/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String url = s1+ip+point+s2+params;
		return url;
    }
    
    /**
	 * <pre>
	 * 方法名: theCustomUrlForCart
	 * 作用: 针对Cart包自定义URL
	 * @param ip ip地址,如果为""或null,默认127.0.0.1 即localhost
	 * @param point 端口,,如果为""或null,默认80端口
	 * @param method 执行的方法 如 getBrandGroupProList
	 * @param param 参数
	 * @return 
	 * 返回值: String url
	 * @Throws 
	 * </pre>
	 */
    @Deprecated
    public static String theCustomUrlForCart(String ip,String point,String method,Map<String,Object> param){
    	if(StringUtils.isBlank(ip)){
    		ip = getLocalIP();
    	}
    	if(StringUtils.isBlank(point)){
    		point = "";
    	}else{
    		point = ":"+point;
    	}
    	String s1 = "http://";
    	String s2 = "/"+projectName+"/services/cart/"+method;
    	String params = "";
    	if(param!=null && param.size()>0){
    		Set<String> keySet = param.keySet();
    		int size = keySet.size();
    		int index = 0;
    		for (String key : keySet) {
    			index++;
				Object value = param.get(key);
				if(index==1 && size>index){
					params += ("?"+key+"="+value+"&");
				}else if(index==1 && size==index){
					params += ("?"+key+"="+value);
				}else if(index==size){
					params += (key+"="+value);
				}else
					params += (key+"="+value+"&");
			}
    	}
    	String url = s1+ip+point+s2+params;
		return url;
    }
   
    /**
     * <pre>
     * 方法名: runUrl
     * 作用: 运行url,并打印结果
     * @param url 
     * 返回值: void
     * @Throws 
     * </pre>
     */
	public static void runUrl(String url){
		System.out.println("--------->URL发送请求地址<---------");
		System.out.println(url);
		try{
			Map map = new HashMap();
			String message = restTemplate.postForObject(url, null, String.class, map);
			System.out.println("----------->URL响应结果<-----------");
			System.out.println(message.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getLocalIP(){
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "127.0.0.1";
		}
	}
	
	/**
	 * <pre>
	 * 方法名: getProjectName
	 * 作用: 获取项目名称
	 * @return 
	 * 返回值: String
	 * @Throws 
	 * </pre>
	 */
	public static String getProjectName(){
		String projectname = System.getProperty("user.dir"); 
		projectname = projectname.substring(projectname.lastIndexOf("\\")+1,projectname.length()); 
		return projectname;
	}
}
