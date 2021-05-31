package main.java.designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:41
 * @since JDK1.8
 */
public class KingHandler {

    private RequestHandler chain;

    public KingHandler() {
        buildChain();
    }

    private void buildChain() {
        chain = new OneHandler(new TwoHandler(new ThreeHandler(null)));
    }

    public void makeRequest(Request request){
        chain.handlerRequest(request);
    }

}
