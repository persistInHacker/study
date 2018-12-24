package designModel.factory.abstractFactory.controller;

import designModel.factory.abstractFactory.Bean;
import designModel.factory.abstractFactory.BeanFactory;

public class ControllerBeanFactory implements BeanFactory{

	@Override
	public Bean createSingleBean() {
		return new SingleControllerBean();
	}

	@Override
	public Bean createSessionBean() {
		return new SessionControllerBean();
	}

	
	
}
