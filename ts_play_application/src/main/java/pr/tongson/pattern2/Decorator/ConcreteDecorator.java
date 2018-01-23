package pr.tongson.pattern2.Decorator;

/**
 * <b>Description:</b> 具体装饰 <br>
 * 花
 * 必须继承自一个共同的父类Component
 * 只有一个的话，可以与Decorator结合。
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public ConcreteDecorator() {
    }

    /**
     * 商业方法，委派给构件，增强功能
     */
    @Override
    public void sampleOperation() {
        super.sampleOperation();
    }
}
