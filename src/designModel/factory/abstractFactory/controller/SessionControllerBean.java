package designModel.factory.abstractFactory.controller;

import designModel.factory.abstractFactory.Bean;

public class SessionControllerBean implements Bean{

	@Override
	public String getName() {
		return "SessionController";
	}

}
