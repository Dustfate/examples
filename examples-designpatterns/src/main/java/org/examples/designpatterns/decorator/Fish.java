package org.examples.designpatterns.decorator;

public class Fish extends Change {
	public Fish(TheGreatestSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		// 代码
		System.out.println("Fish Move");
	}
}
