package pr.tongson.pattern2.Bridge;

/**
 * <b>Create Date:</b> 2017/12/26<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体实例化 <br>
 */
public class ConcreteImplementorA extends Implementor {
    /**
     * 某个商业方法的实现化实现
     */
    @Override
    public void operationImp() {
        System.out.println("operationImp Do something...");
    }
}
