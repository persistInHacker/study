package designModel.factory.simpleFactory;

public class Main {

	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		Bean beanWithId = beanFactory.getBeanWithId("1");
		System.out.println(beanWithId);
		
		Bean beanWithName = beanFactory.getBeanWithName("two");
		System.out.println(beanWithName);
		
	}

}
