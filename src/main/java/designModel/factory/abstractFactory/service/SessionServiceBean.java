package designModel.factory.abstractFactory.service;

import designModel.factory.abstractFactory.Bean;

public class SessionServiceBean implements Bean{

	@Override
	public String getName() {
		return "SessionService";
	}

}
