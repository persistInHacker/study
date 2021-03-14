package designModel.adapter.springadapter;

import java.util.ArrayList;
import java.util.List;

public class DispatchSevlet {

    public static List<HandlerAdapter> handlerAdapterList = new ArrayList<>();

    public  DispatchSevlet(){
        handlerAdapterList.add(new AnnotationHandlerAdapter());
        handlerAdapterList.add(new HttpHandlerAdapter());
        handlerAdapterList.add(new SimpleHandlerAdapter());
    }

    public void doDispatch(){

        AnnotationController annotationController = new AnnotationController();
        HandlerAdapter handlerAdapter = getHandler(annotationController);
        handlerAdapter.handler(annotationController);

    }

    private HandlerAdapter getHandler(Controller controller) {
        for (HandlerAdapter adapter : handlerAdapterList) {
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchSevlet().doDispatch();

    }


}
