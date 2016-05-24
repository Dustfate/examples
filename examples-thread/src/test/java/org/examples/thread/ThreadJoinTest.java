package org.examples.thread;

public class ThreadJoinTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
		ThreadJoin tj1 = new ThreadJoin("A");
		tj1.start();
		ThreadJoin tj2 = new ThreadJoin("B");
		tj2.start();
		
		try {
			tj1.join();
//			tj2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
	}

}
