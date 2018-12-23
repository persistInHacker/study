package designModel.observer;

import designModel.observer.observer.CurrentConditionDiplay;
import designModel.observer.observer.CurrentConditionDiplay2;
import designModel.observer.observer.Observer;
import designModel.observer.subject.WeatherData;

public class Main {

	public static void main(String[] args) {
		Observer ccd = new CurrentConditionDiplay();
		Observer ccd2 = new CurrentConditionDiplay2();
		
		WeatherData wd = new WeatherData();
		wd.registerObserver(ccd);
		wd.registerObserver(ccd2);
		wd.setMeasureMent(0.1f, 0.2f, 0.3f);
		wd.setMeasureMent(0.2f, 0.2f, 0.3f);
	}

}
