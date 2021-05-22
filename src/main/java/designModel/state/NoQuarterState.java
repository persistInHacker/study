package designModel.state;

public class NoQuarterState implements State {
	
	private final GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("投入25分钱");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("不能要求退钱");
	}

	@Override
	public void turnCrank() {
		System.out.println("没钱没糖果");
	}

	@Override
	public void dispense() {
		System.out.println("付钱先");
	}

}
