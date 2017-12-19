package pr.tongson.pattern2.Decorator;

/**
 * <b>Create Date:</b> 2017/12/19<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
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
    }

    private static void Polymorphism() {
        Component component = new ConcreteComponent();
        Component Flowers = new ConcreteDecorator(component);
        Component grass = new ConcreteDecorator1(Flowers);
        Component trees = new ConcreteDecorator2(grass);
        Component wood1 = new ConcreteDecorator3(trees);
    }
}
