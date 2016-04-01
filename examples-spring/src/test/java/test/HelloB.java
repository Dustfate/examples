package test;

//静态类>静态块>构造方法
public class HelloB extends HelloA {

	public HelloB() {
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm b class");
	}
	
	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {
		new HelloB();
	}
}
