package designModel.command;
/**
 * 接收者角色
 *
 */
public class TV {
	private int currChannel;//当前频道
	
	public int getCurrChannel() {
		return currChannel;
	}
	public void setCurrChannel(int currChannel) {
		this.currChannel = currChannel;
	}
	public void turnOn(){
		System.out.println("开电视");
	}
	public void turnOff(){
		System.out.println("关电视");
	}
	public void changeChannel(int channel){
		System.out.println("切换频道:"+channel);
	}
}
