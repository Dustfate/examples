package org.examples.thread;

/**
 * 为什么要用join()方法？
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，
 * 主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，
 * 也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 *
 */
public class ThreadJoin extends Thread {

	private String threadName;

	public ThreadJoin(String threadName) {
		super(threadName);
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");

		for (int i = 0; i < 5; i++) {
			System.out.println("子线程" + threadName + "运行 : " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}

}
