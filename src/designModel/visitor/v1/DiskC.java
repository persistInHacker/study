package designModel.visitor.v1;

/**
 * @author yuhao
 * @version 1.0
 * @date 2021/3/16 14:35
 * @since JDK1.8
 */
public class DiskC implements Disk{

    @Override
    public void accept(Visitor visitor) {
        if(visitor instanceof CVisitor){
            ((CVisitor)visitor).visit(this);
        }else{
            System.out.println(visitor + "没有访问C盘的权限");
        }
    }

    @Override
    public String toString() {
        return "C盘";
    }
}
