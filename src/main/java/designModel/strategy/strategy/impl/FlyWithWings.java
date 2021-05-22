package designModel.strategy.strategy.impl;

import designModel.strategy.strategy.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly whih wings!");
	}

}
