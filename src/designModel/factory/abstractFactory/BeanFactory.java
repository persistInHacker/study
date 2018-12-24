package designModel.factory.abstractFactory;

public interface BeanFactory {

	Bean createSingleBean();
	
	Bean createSessionBean();
}
