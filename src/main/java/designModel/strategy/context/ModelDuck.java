package designModel.strategy.context;

import designModel.strategy.strategy.impl.FlyNoWay;
import designModel.strategy.strategy.impl.QuackNoWay;

public class ModelDuck extends Duck{

	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackNoWay();
	}

	
	
}
