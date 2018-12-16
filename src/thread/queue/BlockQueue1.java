package thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue1 {

	public static void main(String[] args) throws InterruptedException {
		//长度为2的队列
		ArrayBlockingQueue<Object> queue2 = new ArrayBlockingQueue<>(2);
		queue2.add(1);
		queue2.add(2);
		//queue2.add(3);
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll(3 , TimeUnit.SECONDS));
		System.out.println(queue2.size());
	}
	
}
