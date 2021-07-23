package designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:30
 * @since JDK1.8
 */
public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler requestHandler) {
        this.next = requestHandler;
    }

    public void handlerRequest(Request request) {
        if(next != null)
            next.handlerRequest(request);
    }

    public void printHandling(Request request){
        System.out.println(request);
    }

    @Override
    public abstract String toString();

}
