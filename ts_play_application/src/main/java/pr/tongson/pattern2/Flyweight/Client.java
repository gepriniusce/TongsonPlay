package pr.tongson.pattern2.Flyweight;

/**
 * <b>Create Date:</b> 2017/12/25<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 客户端 <br>
 */
public class Client {
    public static void main(String[] args) {
        //创建一个享元工厂对象
        FlyweightFactory factory = new FlyweightFactory();
        //向享元工厂对象请求一个内蕴状态为'a'的享元对象
        Flyweight flyweight = factory.factory(new Character('a'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("First Call");
        //向享元工厂对象请求一个内蕴状态为'b'的享元对象
        flyweight = factory.factory(new Character('b'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("Second Call");
        //向享元工厂对象请求一个内蕴状态为'a'的享元对象
        flyweight = factory.factory(new Character('a'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("Third Call");

        //打印出所有的独立的享元对象，为系统设计过程提供辅助信息
        factory.checkFlyweight();


        pr.tongson.pattern2.Flyweight.Composite.FlyweightFactory factory2 = new pr.tongson.pattern2.Flyweight.Composite.FlyweightFactory();
        Flyweight flyweight1 = factory2.factory("aba");
        flyweight1.operation("Composite Call");
        factory2.checkFlyweight();
    }
}
