package thread.waitNotify;
/**
 *
 */
public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		new Thread(new OutThread(p)).start();
		new Thread(new ReadThread(p)).start();
	}

}
