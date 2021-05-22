package designModel.decorator;
/**
 * 抽象组件
 *
 */

public abstract class Beverage {

	String description = "unkown beverage";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
}
