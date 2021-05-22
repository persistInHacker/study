package designModel.factory.methodFactory;

public class Main {

	public static void main(String[] args) {
		
		Bean createBean = new ServiceBeanFactory().createBean();
		System.out.println(createBean.getName());
		
		Bean createBean2 = new ControllerBeanFactory().createBean();
		System.out.println(createBean2.getName());
		
	}

}
