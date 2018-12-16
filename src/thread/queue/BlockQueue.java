package thread.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BlockQueue {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.add("1");
		queue.add("2");
		queue.add("3");
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
	
}
