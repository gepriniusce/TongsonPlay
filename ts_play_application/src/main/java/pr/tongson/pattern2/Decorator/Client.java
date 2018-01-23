package pr.tongson.pattern2.Decorator;

/**
 * <b>Description:</b>  <br>
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component Flowers = new ConcreteDecorator(component);
        Component grass = new ConcreteDecorator1(component);
        Component trees = new ConcreteDecorator2(component);
        Component wood = new ConcreteDecorator3(component);
        Polymorphism();
        SemiTransparent();
    }

    /**
     * 半透明
     */
    private static void SemiTransparent() {
        Component component = new ConcreteComponent();
        ConcreteDecorator Flowers = new ConcreteDecorator(component);
        ConcreteDecorator1 grass = new ConcreteDecorator1(Flowers);
        ConcreteDecorator2 trees = new ConcreteDecorator2(grass);
        ConcreteDecorator3 wood1 = new ConcreteDecorator3(trees);
    }

    /**
     * 透明
     * 静态
     */
    private static void Polymorphism() {
        Component component = new ConcreteComponent();
        Component Flowers = new ConcreteDecorator(component);
        Component grass = new ConcreteDecorator1(Flowers);
        Component trees = new ConcreteDecorator2(grass);
        Component wood1 = new ConcreteDecorator3(trees);
    }
}
