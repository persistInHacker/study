package designModel.observer.subject;

import java.util.ArrayList;
import java.util.List;

import designModel.observer.observer.Observer;

public class WeatherData implements Subject{
	
	private float temperature;
	private float humidity;
	private float pressure;
	private List<Observer> obList = new ArrayList<>();

	@Override
	public void registerObserver(Observer os) {
		obList.add(os);
	}

	@Override
	public void removeObserver(Observer os) {
		int indexOf = obList.indexOf(os);
		if(indexOf > 0)
			obList.remove(indexOf);
	}

	@Override
	public void notifyAllObserver() {
		for (int i = 0; i < obList.size(); i++) {
			Observer observer = obList.get(i);
			observer.update(temperature , humidity , pressure);
		}
	}
	
	public void setMeasureMent(float temperature ,float humidity ,float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyAllObserver();
	}

}
