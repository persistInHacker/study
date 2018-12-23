package designModel.decorator;

public class Espresso extends Beverage{

	@Override
	public double cost() {
		return 1.99;
	}

	public Espresso() {
		description = "expresso";
	}

	
	
}
