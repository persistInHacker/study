package designModel.factory.abstractFactory.service;

import designModel.factory.abstractFactory.Bean;
import designModel.factory.abstractFactory.BeanFactory;

public class ServiceBeanFactory implements BeanFactory{

	@Override
	public Bean createSingleBean() {
		return new SingleServiceBean();
	}

	@Override
	public Bean createSessionBean() {
		return new SessionServiceBean();
	}


}
