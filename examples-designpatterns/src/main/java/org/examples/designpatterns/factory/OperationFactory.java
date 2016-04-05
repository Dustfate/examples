package org.examples.designpatterns.factory;

/**
 * 简单工厂
 * @Title: OperationFactory.java
 * @Package org.examples.designpatterns.factory
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午1:57:41
 */
public class OperationFactory {
	
	public static Operation createOperation(String operation){
		Operation oper = null;
		switch(operation){
			case "+":
				oper = new OperationAdd();
				break;
			case "-":
				oper = new OperationSub();
				break;
			case "*":
				oper = new OperationMul();
				break;
			case "/":
				oper = new OperationDiv();
				break;
		}
		return oper;
	}
}
