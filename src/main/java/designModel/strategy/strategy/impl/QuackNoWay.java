package designModel.strategy.strategy.impl;

import designModel.strategy.strategy.QuackBehavior;

public class QuackNoWay implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I can't quack!");
	}

}
