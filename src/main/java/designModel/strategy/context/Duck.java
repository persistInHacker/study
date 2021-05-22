package designModel.strategy.context;

import designModel.strategy.strategy.FlyBehavior;
import designModel.strategy.strategy.QuackBehavior;
/**
 * 算法使用者
 *
 */
public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void display() {
		performFly();
		performQuack();
	}
	
	
}
