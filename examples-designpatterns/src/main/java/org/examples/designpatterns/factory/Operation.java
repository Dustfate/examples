package org.examples.designpatterns.factory;

/**
 * 计算类
 * @Title: Operation.java
 * @Package org.examples.designpatterns.factory
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午2:06:16
 */
public interface Operation {
	
	public abstract double getResult(double numberA, double numberB);
	
}
