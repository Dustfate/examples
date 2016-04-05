package org.examples.designpatterns.template;

public class Tea extends Beverage {

	@Override
	public void brew() {
		System.out.println("冲泡茶叶");
	}

	@Override
	public void addCondiments() {
		System.out.println("添加柠檬");
	}

}
