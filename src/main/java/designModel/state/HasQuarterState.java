package designModel.state;
/**
 * 有25分钱
 * @author yuhao
 *
 */
public class HasQuarterState implements State {

	private final GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine) {
		super();
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("不能这么搞");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("退回25分");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("手柄转动");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	@Override
	public void dispense() {
		System.out.println("不能这么搞");
	}

}
