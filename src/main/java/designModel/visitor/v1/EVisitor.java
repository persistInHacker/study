package designModel.visitor.v1;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 13:51
 * @since JDK1.8
 */
public interface EVisitor extends Visitor {

    void visit(DiskE diskE);

}
