package designModel.visitor.v1;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 13:50
 * @since JDK1.8
 */
public interface DVisitor extends Visitor {

    void visit(DiskD diskD);

}
