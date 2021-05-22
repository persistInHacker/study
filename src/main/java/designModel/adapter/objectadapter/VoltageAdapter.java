package designModel.adapter.objectadapter;


public class VoltageAdapter implements Voltage5V {

    private final Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output() {
        return voltage220V.getVoltage()/44;
    }
}
