package designModel.state;

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(2);
		System.out.println(gumballMachine.getState());
		
		gumballMachine.insertQuarter();
		System.out.println(gumballMachine.getState());
		gumballMachine.turnCrank();
		System.out.println(gumballMachine.getState());
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine.getState());
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine.getState());
		System.out.println(gumballMachine.getCount());
		
	}

}
