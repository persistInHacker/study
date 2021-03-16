package designModel.visitor.v1;


/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 14:13
 * @since JDK1.8
 */
public class App {

    public static void main(String[] args) {

        OrdinaryVisitor ordinaryVisitor = new OrdinaryVisitor();
        RootVisitor rootVisitor = new RootVisitor();

        DiskC diskC = new DiskC();
        DiskD diskD = new DiskD();
        DiskE diskE = new DiskE();
        diskC.accept(ordinaryVisitor);
        diskC.accept(rootVisitor);
        diskD.accept(ordinaryVisitor);
        diskD.accept(rootVisitor);
        diskE.accept(ordinaryVisitor);
        diskE.accept(rootVisitor);
    }

}
