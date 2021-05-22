package designModel.visitor.v1;


/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 14:07
 * @since JDK1.8
 */
public class OrdinaryVisitor implements DVisitor,EVisitor {
    @Override
    public void visit(DiskD diskD) {
        System.out.println("Ordinary visit Disk D");
    }

    @Override
    public String toString() {
        return "普通用户";
    }

    @Override
    public void visit(DiskE diskE) {
        System.out.println("Ordinary visit Disk E");
    }
}
