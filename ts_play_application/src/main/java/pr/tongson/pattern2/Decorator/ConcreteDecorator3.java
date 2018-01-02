package pr.tongson.pattern2.Decorator;

/**
 * <b>Description:</b> 具体装饰 <br>
 * 木
 */
public class ConcreteDecorator3 extends Decorator {
    public ConcreteDecorator3(Component component) {
        super(component);
    }

    public ConcreteDecorator3() {
    }

    /**
     * 商业方法，委派给构件，增强功能
     */
    @Override
    public void sampleOperation() {
        super.sampleOperation();
    }
}
