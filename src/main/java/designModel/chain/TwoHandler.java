package designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:36
 * @since JDK1.8
 */
public class TwoHandler extends designModel.chain.RequestHandler {


    public TwoHandler(designModel.chain.RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handlerRequest(designModel.chain.Request request) {
        if (request.getRequestType() == designModel.chain.RequestType.TWO) {
            request.setHandler(true);
            printHandling(request);
        } else {
            super.handlerRequest(request);
        }
    }

    @Override
    public String toString() {
        return "ONE";
    }
}
