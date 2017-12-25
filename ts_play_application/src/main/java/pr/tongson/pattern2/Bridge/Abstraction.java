package pr.tongson.pattern2.Bridge;

/**
 * <b>Create Date:</b> 2017/12/26<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象化 <br>
 */
abstract public class Abstraction {
    protected Implementor imp;

    public void operation() {
        imp.operationImp();
    }
}
