package org.examples.designpatterns.singleton;

/**
 * 饿汉式单例类
 * @Title: EagerSingleton.java
 * @Package org.examples.designpatterns.singleton
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午3:03:32
 */
public class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton(){
		
	}
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static EagerSingleton getInstance(){
		
		return instance;
	}
	
}
