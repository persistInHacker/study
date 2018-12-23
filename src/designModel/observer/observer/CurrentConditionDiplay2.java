package designModel.observer.observer;

public class CurrentConditionDiplay2 implements Observer{

	private float temperature;
	private float humidity;
	private float pressure;
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	public void display() {
		System.out.println("CurrentConditionDiplay2 [temperature=" + temperature + ", humidity=" + humidity + ", pressure="
				+ pressure + "]");
	}
	
	
}
