package org.examples.designpatterns.proxy;

public class RealObject extends AbstractObject {

	@Override
	public void operation() {
		System.out.println("do someting");
	}

}
