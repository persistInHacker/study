package designModel.state;

public class SoldOutState implements State {

	private final GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("卖完了");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("不能这么搞");
	}

	@Override
	public void turnCrank() {
		System.out.println("不能这么搞");
	}

	@Override
	public void dispense() {
		System.out.println("不能这么搞");
	}

}
