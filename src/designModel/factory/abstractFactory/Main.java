package designModel.factory.abstractFactory;

import designModel.factory.abstractFactory.controller.ControllerBeanFactory;
import designModel.factory.abstractFactory.service.ServiceBeanFactory;

public class Main {

	public static void main(String[] args) {
		
		ControllerBeanFactory cb = new ControllerBeanFactory();
		Bean sessionBean = cb.createSessionBean();
		System.out.println(sessionBean.getName());
		
		Bean singleBean = cb.createSingleBean();
		System.out.println(singleBean.getName());
		
		ServiceBeanFactory sb = new ServiceBeanFactory();
		Bean createSessionBean = sb.createSessionBean();
		System.out.println(createSessionBean.getName());
		
	}

}
