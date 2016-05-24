package org.examples.thread;

public class TicketSeller implements Runnable {
	
	private static int ticket = 100;
	private static Object lock = new Object();
	
	private String windowsName;
	
	public TicketSeller(String windowsName) {
		this.windowsName = windowsName;
	}


	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				/************ 每次售票前进行判断 ************/
				if (ticket == 0) {
					break;
				}
				
				/************ 模拟售票的网络延迟 ************/
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/************ 符合条件后进行售票 ************/
				System.out.println(windowsName + " 售出了第　"
						+ ticket-- + "　张票");
			}
		}
	}

}
