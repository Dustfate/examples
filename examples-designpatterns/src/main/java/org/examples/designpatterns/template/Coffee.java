package org.examples.designpatterns.template;

public class Coffee extends Beverage {

	@Override
	public void brew() {
		System.out.println("冲泡咖啡豆");
	}

	@Override
	public void addCondiments() {
		System.out.println("添加糖和牛奶");
	}

}
