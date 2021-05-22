package designModel.adapter.classadapter;

public class Phone {


    public void charging(Voltage5V voltage5V){
        voltage5V.output5v();
        System.out.println("给手机充电");
    }

}
