package designModel.factory.methodFactory;

public class ServiceBeanFactory implements BeanFactory{

	@Override
	public Bean createBean() {
		return new ServiceBean();
	}

}
