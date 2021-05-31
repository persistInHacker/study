package main.java.designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:43
 * @since JDK1.8
 */
public class App {

    public static void main(String[] args) {

        KingHandler kingHandler = new KingHandler();
        kingHandler.makeRequest(new Request(RequestType.ONE , "the one" , false));
        kingHandler.makeRequest(new Request(RequestType.TWO, "the two" , false));
        kingHandler.makeRequest(new Request(RequestType.THREE , "the three" , false));

    }
}
