package designModel.state;

public class SoldState implements State {

	private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	@Override
	public void insertQuarter() {
		System.out.println("不能这么搞");
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
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0)
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		else {
			System.out.println("卖完了");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
