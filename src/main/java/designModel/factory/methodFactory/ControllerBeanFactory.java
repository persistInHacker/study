package designModel.factory.methodFactory;

public class ControllerBeanFactory implements BeanFactory{

	@Override
	public Bean createBean() {
		return new ControllerBean();
	}
	
	
}
