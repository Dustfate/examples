package org.examples.designpatterns.template;

public class TestTemplate {
	
	public static void main(String[] args) {
		System.out.println("============= 准备茶 =============");
		Beverage tea = new Tea();
		tea.prepareBeverage();
		
		System.out.println("============= 准备咖啡 =============");
	    Beverage coffee = new Coffee();
	    coffee.prepareBeverage();
	}
	
}
