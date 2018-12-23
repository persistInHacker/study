package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

	
	public static void main(String[] args) {
		Demo d = new Demo();
		new Thread(new Demo()).start();
		new Thread(new Demo()).start();
		
	}

}


class Demo implements Runnable{
	private static AtomicInteger ai = new AtomicInteger();
	private static int i = 0;
	@Override
	public void run() {
		
		while(i < 100) {
			 i = ai.incrementAndGet();
			//i++;
			System.out.println(Thread.currentThread().getName() + "--" + i);
		}
		
	}
	
}