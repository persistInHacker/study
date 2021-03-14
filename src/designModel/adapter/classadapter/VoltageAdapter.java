package designModel.adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements Voltage5V{


    @Override
    public int output5v() {
        int i = super.output220v();
        System.out.println("适配220V电压到5V");
        return 5;
    }
}
