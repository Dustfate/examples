package org.examples.designpatterns.strategy;

public class PriceFactory {

	/**
	 * 持有一个具体策略的对象
	 */
	private MemberStrategy strategy;

	/**
	 * 构造函数，根据传入的不同类别生成相应的对象
	 * @param strategy 具体策略对象
	 */
	public PriceFactory(String type) {
		switch (type) {
		case "primary":
			this.strategy = new PrimaryMemberStrategy();
			break;
		case "intermediate":
			this.strategy = new IntermediateMemberStrategy();
			break;
		case "advanced":
			this.strategy = new AdvancedMemberStrategy();
			break;
		}
	}

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 *            图书原价格
	 * @return 打折后的价格
	 */
	public double quote(double booksPrice) {
		return this.strategy.calcPrice(booksPrice);
	}
}
