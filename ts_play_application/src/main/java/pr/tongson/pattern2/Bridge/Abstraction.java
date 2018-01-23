package pr.tongson.pattern2.Bridge;

/**
 * <b>Description:</b> 抽象化 <br>
 */
abstract public class Abstraction {
    protected Implementor imp;

    public void operation() {
        imp.operationImp();
    }
}
