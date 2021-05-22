package thread.waitNotify;

public class ReadThread implements Runnable{

	private final Person p;
	public ReadThread(Person p) {
		super();
		this.p = p;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (p) {
				if(!p.isFlag()) {
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(p);
				p.setFlag(false);
				p.notify();
			}
		}
	}

}
