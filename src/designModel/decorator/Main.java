package designModel.decorator;

import designModel.decorator.decorator.Milk;
import designModel.decorator.decorator.Mocha;

public class Main {

	public static void main(String[] args) {
		Beverage es = new Espresso();
		System.out.println(es.getDescription() + " $ " + es.cost());
		
		Beverage mocha = new Mocha(es);
		System.out.println(mocha.getDescription() + " $ " + mocha.cost());
		
		Beverage dr = new DarkRoast();//需要装饰的对象
		dr = new Mocha(dr);//装饰dr
		dr = new Mocha(dr);
		dr = new Milk(dr);
		System.out.println(dr.getDescription() + " $ " + dr.cost());
	}
	
}
