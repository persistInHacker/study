package designModel.decorator.decorator;

import designModel.decorator.Beverage;

/**
 * 抽象装饰者
 *
 */
public abstract class CondimentDecorator extends Beverage{

	public abstract String getDescription();
	
}
