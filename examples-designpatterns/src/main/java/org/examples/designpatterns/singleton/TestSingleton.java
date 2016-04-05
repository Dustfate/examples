package org.examples.designpatterns.singleton;

/**
 * 单例模式
 * @Title: TestSingleton.java
 * @Package org.examples.designpatterns.singleton
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午3:27:03
 */
public class TestSingleton {
	
	public static void main(String[] args) {
		EagerSingleton eagerSingleton = EagerSingleton.getInstance();
		
		LazySingleton lazySingleton = LazySingleton.getInstance();
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if(s1 == s2){
			System.out.println("true");
		}
	}

}
