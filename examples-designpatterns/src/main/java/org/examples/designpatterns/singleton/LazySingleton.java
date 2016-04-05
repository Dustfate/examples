package org.examples.designpatterns.singleton;

/**
 * 懒汉式单例类
 * @Title: LazySingleton.java
 * @Package org.examples.designpatterns.singleton
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午3:07:41
 */
public class LazySingleton {
	
	private static LazySingleton instance = null;
	
	private LazySingleton(){
		
	}
	
	/**
	 * 静态工厂方法
	 * @return
	 */
	public static synchronized LazySingleton getInstance(){
		if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
	}

}
