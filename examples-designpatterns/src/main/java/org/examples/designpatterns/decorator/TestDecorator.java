package org.examples.designpatterns.decorator;

/**
 * 装饰模式
 * @Title: TestDecorator.java
 * @Package org.examples.designpatterns.decorator
 * @Description: TODO(用一句话描述该文件做什么)
 * @author dusf
 * @date 2016年4月6日 下午1:02:30
 */
public class TestDecorator {

	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		// 第一种写法
		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(bird);
		bird.move();
		fish.move();
		// 第二种写法
		TheGreatestSage bird2 = new Bird(sage);
		bird2.move();
		TheGreatestSage fish2 = new Fish(sage);
		fish2.move();
	}

}
