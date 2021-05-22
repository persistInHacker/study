package thread.ticket;

import java.util.concurrent.CountDownLatch;

public class Ticket1 {
	private static final CountDownLatch cd = new CountDownLatch(50);
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new Thread(new Sale1()).start();
			cd.countDown();
		}
	}
}

class Sale1 implements Runnable{
	private static  int tick = 20;
	//private static ThreadLocal<Integer> i = new ThreadLocal<>();

	@Override		
	public void run() {
		while (tick > 0) {
			//synchronized (Ticket1.class) {
				if(tick == 0) {
					break;
				}
				if (tick > 0) {
					System.out.println(Thread.currentThread().getName()+ "---" + tick );
				}
				try {
					Thread.sleep(100L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tick --;
			//}
		}
	}
}

