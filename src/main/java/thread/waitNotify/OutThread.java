package thread.waitNotify;

public class OutThread implements Runnable{

	private final Person p;
	
	public OutThread(Person p) {
		super();
		this.p = p;
	}


	@Override
	public void run() {
		int count = 0;
		while(true) {
			synchronized (p) {
				if(p.isFlag()) {
					try {
						p.wait();
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					
				if(count == 0) {
					p.setAge(1);
					p.setName("����");
				}else {
					p.setAge(2);
					p.setName("����");
				}
				count = (count + 1) % 2;
				p.setFlag(true);
				p.notify();
			}
		}
		
	}

}
