package pr.tongson.pattern2.Decorator;

/**
 * <b>Description:</b> 具体装饰 <br>
 * 树
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    public ConcreteDecorator2() {
    }

    /**
     * 商业方法，委派给构件，增强功能
     */
    @Override
    public void sampleOperation() {
        super.sampleOperation();
    }
}
