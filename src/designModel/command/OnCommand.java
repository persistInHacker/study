package designModel.command;
/**
 * 具体命令角色 
 * 包含一个接收者角色对象的引用
 *
 */
public class OnCommand implements Command {
	private TV tv;
	public OnCommand(TV tv){
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOn();
	}

}
