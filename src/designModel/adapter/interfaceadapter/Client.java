package designModel.adapter.interfaceadapter;

/**
 * 通过抽象类空实现了接口中的所有方法，而在调用的时候，有选择的使用某些方法
 */
public class Client {

    public static void main(String[] args) {

        AbstractA aa = new AbstractA() {
            @Override
            public void m1() {
                System.out.println("实现了m1方法");
            }
        };
        aa.m1();


    }
}
