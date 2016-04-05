package org.examples.designpatterns.factory;

public class OperationMul implements Operation {

	/**
	 * 乘法运算
	 */
	@Override
	public double getResult(double numberA, double numberB) {
		
		return numberA * numberB;
	}

}
