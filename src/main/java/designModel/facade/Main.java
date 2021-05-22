package designModel.facade;

public class Main {

	public static void main(String[] args) {

		WakeUpFacade w = new WakeUpFacade(new Eye(), new Teeth(), new Clothes());
		w.wakeUp();
		
		System.out.println("--------");
		
		w.sleep();
	}

}
