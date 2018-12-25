package designModel.command;
/**
 * 命令者模式
 *
 */
public class Main {

	public static void main(String[] args) {
		//接收者
		TV tv = new TV();

		//命令
		OnCommand on = new OnCommand(tv);
		OffCommand off = new OffCommand(tv);
		ChangeChannelCommand changeChannel = 
				new ChangeChannelCommand(tv, 3); 
		
		on.execute();
		
		//发送者
		Control c = new Control(on,off,changeChannel);
		//发送者发送请求
		c.turnOn();
		c.changeChannel();
		c.turnOff();
		
	}

}
