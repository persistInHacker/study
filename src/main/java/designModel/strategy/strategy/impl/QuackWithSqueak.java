package designModel.strategy.strategy.impl;

import designModel.strategy.strategy.QuackBehavior;

public class QuackWithSqueak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("I can quack with squeak!");
	}

}
