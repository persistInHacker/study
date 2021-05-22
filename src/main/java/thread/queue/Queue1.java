package thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread implements Runnable {
	private final BlockingQueue<String> blockingQueue;
	private final AtomicInteger count = new AtomicInteger();
	private volatile boolean FLAG = true;

	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "生产者开始启动....");
		while (FLAG) {
			String data = count.incrementAndGet() + "";
			try {
				boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
				if (offer) {
					System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "成功..");
				} else {
					System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "失败..");
				}
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
		System.out.println(Thread.currentThread().getName() + ",生产者线程停止...");
	}

	public void stop() {
		this.FLAG = false;
	}

}

class ConsumerThread implements Runnable {
	private volatile boolean FLAG = true;
	private final BlockingQueue<String> blockingQueue;

	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "消费者开始启动....");
		while (FLAG) {
			try {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (data == null || data == "") {
					FLAG = false;
					System.out.println("消费者超过2秒时间未获取到消息.");
					return;
				}
				System.out.println("消费者获取到队列信息成功,data:" + data);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}

public class Queue1 {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(3);
		ProducerThread producerThread = new ProducerThread(blockingQueue);
		ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
		Thread t1 = new Thread(producerThread);
		Thread t2 = new Thread(consumerThread);
		t1.start();
		t2.start();
		//10秒后 停止线程..
		try {
			Thread.sleep(10*1000);
			producerThread.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
