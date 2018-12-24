package designModel.factory.abstractFactory.controller;

import designModel.factory.abstractFactory.Bean;

public class SingleControllerBean implements Bean {

	@Override
	public String getName() {
		return "SingleController";
	}

	
}
