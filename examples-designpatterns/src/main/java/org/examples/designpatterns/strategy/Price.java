package org.examples.designpatterns.strategy;

public class Price {
	
	/**
	 * 持有一个具体策略的对象
	 */
	private MemberStrategy strategy;
	
	/**
	 * 构造函数，传入一个具体策略对象
	 * @param strategy 具体策略对象
	 */
	public Price(MemberStrategy strategy){
		this.strategy = strategy;
	}
	
	/**
	 * 计算图书的价格
	 * @param booksPrice 图书原价格
	 * @return 打折后的价格
	 */
	public double quote(double booksPrice){
		return this.strategy.calcPrice(booksPrice);
	}
}
