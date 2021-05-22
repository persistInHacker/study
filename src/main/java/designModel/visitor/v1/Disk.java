package designModel.visitor.v1;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 14:35
 * @since JDK1.8
 */
public interface Disk {
    void accept(Visitor visitor);
}
