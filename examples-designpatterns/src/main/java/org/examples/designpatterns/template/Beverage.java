package org.examples.designpatterns.template;

/**
 * 饮料
 * @Title: Beverage.java
 * @Package org.examples.designpatterns.template
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 上午9:47:27
 */
public abstract class Beverage {

	// 模板方法，决定了算法骨架。相当于TemplateMethod()方法
	public void prepareBeverage() {
		boilWater();
		brew();
		pourInCup();
		if (customWantsCondiments()) {
			addCondiments();
		}
	}

	/**
	 * 共性操作，直接在抽象类中定义
	 */
	public void boilWater() {
		System.out.println("烧开水");
	}

	/**
	 * 共性操作，直接在抽象类中定义
	 */
	public void pourInCup() {
		System.out.println("倒入杯中");
	}

	// 钩子方法，决定某些算法步骤是否挂钩在算法中
	public boolean customWantsCondiments() {
		return true;
	}

	// 特殊操作，在子类中具体实现
	public abstract void brew();

	// 特殊操作，在子类中具体实现
	public abstract void addCondiments();

}
