package org.examples.designpatterns.factory;

public class TestFacroty {
	public static void main(String[] args) {
		
		Operation operation = OperationFactory.createOperation("+");
		System.out.println(operation.getResult(1, 2));
		
		operation = OperationFactory.createOperation("-");
		System.out.println(operation.getResult(1, 2));
	}
}
