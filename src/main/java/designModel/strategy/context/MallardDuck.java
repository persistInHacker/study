package designModel.strategy.context;

import designModel.strategy.strategy.impl.FlyWithWings;
import designModel.strategy.strategy.impl.QuackWithSqueak;

public class MallardDuck extends Duck{

	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new QuackWithSqueak();
	}

	
}
