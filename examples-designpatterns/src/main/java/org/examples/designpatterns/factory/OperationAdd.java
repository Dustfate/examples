package org.examples.designpatterns.factory;

public class OperationAdd implements Operation {

	/**
	 * 加法运算
	 */
	@Override
	public double getResult(double numberA, double numberB) {
		
		return numberA + numberB;
	}

}
