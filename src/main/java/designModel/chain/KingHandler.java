package designModel.chain;

import designModel.chain.OneHandler;
import designModel.chain.Request;
import designModel.chain.TwoHandler;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:41
 * @since JDK1.8
 */
public class KingHandler {

    private designModel.chain.RequestHandler chain;

    public KingHandler() {
        buildChain();
    }

    private void buildChain() {
        chain = new OneHandler(new TwoHandler(new designModel.chain.ThreeHandler(null)));
    }

    public void makeRequest(Request request){
        chain.handlerRequest(request);
    }

}
