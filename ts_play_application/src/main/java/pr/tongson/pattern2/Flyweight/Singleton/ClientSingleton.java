package pr.tongson.pattern2.Flyweight.Singleton;

import pr.tongson.pattern2.Flyweight.Flyweight;

/**
 * <b>Description:</b>  <br>
 */
public class ClientSingleton {
    private static FlyweightFactorySingleton flyweightFactorySingleton;

    public static void main(String[] args) {
        //创建一个享元工厂对象
        flyweightFactorySingleton= FlyweightFactorySingleton.getInstance();
        //向享元工厂对象请求一个内蕴状态为'a'的享元对象
        Flyweight flyweight = flyweightFactorySingleton.factory(new Character('a'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("First Call");
        //向享元工厂对象请求一个内蕴状态为'b'的享元对象
        flyweight = flyweightFactorySingleton.factory(new Character('b'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("Second Call");
        //向享元工厂对象请求一个内蕴状态为'a'的享元对象
        flyweight = flyweightFactorySingleton.factory(new Character('a'));
        //以参数方式传入一个外蕴状态
        flyweight.operation("Third Call");

        //打印出所有的独立的享元对象，为系统设计过程提供辅助信息
        flyweightFactorySingleton.checkFlyweight();
    }
}
