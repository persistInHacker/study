package designModel.factory.simpleFactory;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

	private final Map<String , Bean> beanMap = new HashMap<>();
	
	//模拟bean初始化
	public BeanFactory() {
		beanMap.put("1", new Bean("001","first"));
		beanMap.put("two", new Bean("002","two"));
		beanMap.put("3", new Bean("003","three"));
	}
	
	Bean getBeanWithId(String id) {
		return beanMap.get(id);
	}
	
	Bean getBeanWithName(String name) {
		return beanMap.get(name);
	}
	
}
