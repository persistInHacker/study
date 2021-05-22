package designModel.factory.abstractFactory.service;

import designModel.factory.abstractFactory.Bean;

public class SingleServiceBean implements Bean{

	@Override
	public String getName() {
		return "SingleService";
	}

}
