package org.examples.designpatterns.factory;

public class OperationSub implements Operation {

	/**
	 * 减法运算
	 */
	@Override
	public double getResult(double numberA, double numberB) {
		
		return numberA - numberB;
	}

}
