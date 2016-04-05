package org.examples.designpatterns.factory;

public class OperationDiv implements Operation {

	/**
	 * 除法运算
	 */
	@Override
	public double getResult(double numberA, double numberB) {
		if (numberB == 0) {
			new Exception("除数不能为零。");
		}
		return numberA / numberB;
	}

}
