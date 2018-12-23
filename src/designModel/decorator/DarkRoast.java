package designModel.decorator;
/**
 * 具体组件 需要装饰的对象
 *
 */
public class DarkRoast extends Beverage{

	@Override
	public double cost() {
		return 0.8;
	}
	
	public DarkRoast() {
		description = "darkRoast";
	}

}
