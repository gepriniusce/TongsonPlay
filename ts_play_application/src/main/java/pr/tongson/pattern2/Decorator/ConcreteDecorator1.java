package pr.tongson.pattern2.Decorator;

/**
 * <b>Description:</b> 具体装饰 <br>
 * 草
 */
public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    public ConcreteDecorator1() {
    }

    /**
     * 商业方法，委派给构件，增强功能
     */
    @Override
    public void sampleOperation() {
        super.sampleOperation();
    }
}
