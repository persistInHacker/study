package designModel.facade;

public class WakeUpFacade {

	private final Eye eye;
	private final Teeth teeth;
	private final Clothes clothes;
	
	public WakeUpFacade(Eye eye, Teeth teeth, Clothes clothes) {
		super();
		this.eye = eye;
		this.teeth = teeth;
		this.clothes = clothes;
	}
	
	public void wakeUp() {
		eye.openEyes();
		clothes.putOnClothes();
		teeth.squeezeToothpaste();
		teeth.brushTeeth();
	}
	
	public void sleep() {
		eye.closeEyes();
		clothes.takeOffClothes();
		teeth.squeezeToothpaste();
		teeth.brushTeeth();
	}
	
}
