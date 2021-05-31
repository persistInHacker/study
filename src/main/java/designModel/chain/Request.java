package designModel.chain;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/25 10:32
 * @since JDK1.8
 */
public class Request {

    private designModel.chain.RequestType requestType;
    private String reqDesc;
    private boolean handler;

    public Request(designModel.chain.RequestType requestType, String reqDesc, boolean handler) {
        this.requestType = requestType;
        this.reqDesc = reqDesc;
        this.handler = handler;
    }

    public designModel.chain.RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(designModel.chain.RequestType requestType) {
        this.requestType = requestType;
    }

    public String getReqDesc() {
        return reqDesc;
    }

    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc;
    }

    public boolean isHandler() {
        return handler;
    }

    public void setHandler(boolean handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", reqDesc='" + reqDesc + '\'' +
                ", handler=" + handler +
                '}';
    }
}
