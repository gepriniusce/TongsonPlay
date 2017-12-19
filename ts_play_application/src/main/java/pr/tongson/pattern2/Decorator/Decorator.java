package pr.tongson.pattern2.Decorator;

/**
 * <b>Create Date:</b> 2017/12/19<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象装饰 <br>
 *     七十二般变化
 */
public class Decorator implements Component {

    private Component mComponent;

    /**
     * 构造子
     *
     * @param component
     */
    public Decorator(Component component) {
        this.mComponent = component;
    }

    /**
     * 构造子
     */
    public Decorator() {
    }

    /**
     * 商业方法，委派给构件
     */
    @Override
    public void sampleOperation() {
        if (mComponent != null) {
            mComponent.sampleOperation();
        }
    }
}
