package org.examples.designpatterns.strategy;

public interface MemberStrategy {
	
	/**
	 * 计算图书价格（抽象策略类）
	 * @param booksPrice
	 * @return
	 */
	public double calcPrice(double booksPrice);
}
