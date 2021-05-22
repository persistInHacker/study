package thread.ticket;

public class Ticket {

	public static void main(String[] args) {
		int count = 100;
		Sale sale = new Sale(count);
		new Thread(sale).start();
		new Thread(sale).start();
	}
	
}

class Sale implements Runnable{

	private int count = 0;
	
	public Sale(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		while(count > 0) {
			synchronized (this) {
				if(count <= 0) {
					return;
				}
				try {
					Thread.sleep(50L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "---" + count);
				count--;
			}
		}
	}
}

