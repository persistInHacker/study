package main.java.designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:36
 * @since JDK1.8
 */
public class ThreeHandler extends RequestHandler {


    public ThreeHandler(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handlerRequest(Request request) {
        if (request.getRequestType() == RequestType.THREE) {
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
