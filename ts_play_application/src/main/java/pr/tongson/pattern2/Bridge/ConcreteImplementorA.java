package pr.tongson.pattern2.Bridge;

/**
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
