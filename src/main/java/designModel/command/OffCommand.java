package designModel.command;
/**
 * 具体命令角色 
 * 包含一个接收者角色对象的引用
 *
 */
public class OffCommand implements Command {
	private final TV tv;
	public OffCommand(TV tv){
		this.tv = tv;
	}
	@Override
	public void execute() {
		tv.turnOff();
	}

}
