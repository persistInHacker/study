package designModel.visitor.v1;


/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 14:07
 * @since JDK1.8
 */
public class RootVisitor implements AllUserVisitor {
    @Override
    public void visit(DiskD diskC) {
        System.out.println("root visit Disk D");
    }

    @Override
    public void visit(DiskC diskC) {
        System.out.println("root visit Disk C");
    }

    @Override
    public String toString() {
        return "root用户";
    }

    @Override
    public void visit(DiskE diskE) {
            System.out.println("root visit Disk E");
    }
}
