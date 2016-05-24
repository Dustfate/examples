package org.examples.thread;

/**
 * Unit test for simple App.
 */
public class ThreadTest {

	public static void main(String[] args) {
		new Thread(new TicketSeller("1")).start();
		new Thread(new TicketSeller("2")).start();
		new Thread(new TicketSeller("3")).start();
	}
}
