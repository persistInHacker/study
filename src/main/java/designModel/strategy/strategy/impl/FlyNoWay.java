package designModel.strategy.strategy.impl;

import designModel.strategy.strategy.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly!");
	}

}
