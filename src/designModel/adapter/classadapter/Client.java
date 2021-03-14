package designModel.adapter.classadapter;

/**
 * 类适配器模式
 * 1)Java 是单继承机制，所以类适配器需要继承 src 类这一点算是一个缺点, 因为这要求 dst 必须是接口，有一定局限性;
 * 2)src 类的方法在 Adapter 中都会暴露出来，也增加了使用的成本。
 * 由于其继承了 src 类，所以它可以根据需求重写 src 类的方法，使得 Adapter 的灵活性增强了
 */
public class Client {



    public static void main(String[] args) {
         Phone phone = new Phone();
         phone.charging(new VoltageAdapter());

    }

}
