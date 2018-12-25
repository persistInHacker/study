package designModel.command;
/**
 * 遥控器
 * 发送者角色   
 * 持有需要发送的命令对象
 *
 */
public class Control {
	private OnCommand on;
	private OffCommand off;
	private ChangeChannelCommand changeCommand;
	public OnCommand getOn() {
		return on;
	}
	public void setOn(OnCommand on) {
		this.on = on;
	}
	public OffCommand getOff() {
		return off;
	}
	public void setOff(OffCommand off) {
		this.off = off;
	}
	public ChangeChannelCommand getChangeCommand() {
		return changeCommand;
	}
	public void setChangeCommand(ChangeChannelCommand changeCommand) {
		this.changeCommand = changeCommand;
	}
	public Control(OnCommand on, OffCommand off,
			ChangeChannelCommand changeCommand) {
		super();
		this.on = on;
		this.off = off;
		this.changeCommand = changeCommand;
	}
	public Control() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void turnOn(){
		on.execute();
	}
	public void turnOff(){
		off.execute();
	}
	public void changeChannel(){
		changeCommand.execute();
	}
}
