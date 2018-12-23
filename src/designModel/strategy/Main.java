package designModel.strategy;

import designModel.strategy.context.MallardDuck;
import designModel.strategy.context.ModelDuck;

public class Main {

	public static void main(String[] args) {

		MallardDuck md = new MallardDuck();
		md.display();
		
		ModelDuck modelDuck = new ModelDuck();
		modelDuck.display();
	}

}
