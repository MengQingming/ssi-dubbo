package com.hm.SSI.start;

import com.alibaba.dubbo.container.Main;

/**
 * 
 * 类名：StartProviderService
 * 作用：
 * 作者：mengqingming
 * 日期：2015-11-30下午02:21:42
 * 版本： V 1.0
 *
 */
public class StartProviderService {
	
	public static void main(String[] args) {
		
		/**
		 * 使用Dubbo提供的main方法，可优雅停机
		 *   读取dubbo.properties加载spring容器
		 */
		Main.main(args);
	}
	
}
