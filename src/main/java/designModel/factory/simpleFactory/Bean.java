package designModel.factory.simpleFactory;

public class Bean {

	private String name;
	
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bean [name=" + name + ", id=" + id + "]";
	}

	public Bean(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Bean() {
	}
	
	
	
}
