package org.examples.designpatterns.strategy;

/**
 * 策略模式
 * @Title: TestStrateby.java
 * @Package org.examples.designpatterns.strategy
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月5日 下午4:34:33
 */
public class TestStrateby {
	public static void main(String[] args) {
		MemberStrategy strategy = new AdvancedMemberStrategy();
		Price price = new Price(strategy);
		double quote = price.quote(300);
		System.out.println("图书的最终价格为：" + quote);
		
		PriceFactory pf = new PriceFactory("intermediate");
		quote = pf.quote(300);
		System.out.println("图书的最终价格为：" + quote);
	}
}
