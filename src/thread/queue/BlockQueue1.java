package thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue1 {

	public static void main(String[] args) throws InterruptedException {
		//����Ϊ2�Ķ���
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
