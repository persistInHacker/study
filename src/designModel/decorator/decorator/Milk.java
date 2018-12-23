package designModel.decorator.decorator;

import designModel.decorator.Beverage;

public class Milk extends CondimentDecorator{

	Beverage beverage;
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " , milk";
	}

	@Override
	public double cost() {
		return 0.1 + beverage.cost();
	}

}
