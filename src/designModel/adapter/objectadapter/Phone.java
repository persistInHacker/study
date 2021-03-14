package designModel.adapter.objectadapter;

public class Phone {


    public void charging(VoltageAdapter voltageAdapter){
        int output = voltageAdapter.output();
        System.out.println("给手机充电，电压：" + output);
    }

}
