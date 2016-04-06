package org.examples.designpatterns.proxy;

public class TestProxy {

	public static void main(String[] args) {
		AbstractObject ao = new ProxyObject();
		ao.operation();

	}

}
