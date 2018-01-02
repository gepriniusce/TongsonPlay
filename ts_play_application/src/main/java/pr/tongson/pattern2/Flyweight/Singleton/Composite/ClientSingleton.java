package pr.tongson.pattern2.Flyweight.Singleton.Composite;


import pr.tongson.pattern2.Flyweight.Flyweight;

/**
 * <b>Description:</b>  <br>
 */
public class ClientSingleton {
    private static FlyweightFactorySingleton flyweightFactorySingleton;

    public static void main(String[] args) {
        //创建一个享元工厂对象
        flyweightFactorySingleton = FlyweightFactorySingleton.getInstance();
        //向享元工厂对象请求一个状态为"aba"的复合享元对象
        Flyweight flyweight = flyweightFactorySingleton.factory("aba");
        //以一个外蕴状态传入享元对象中
        flyweight.operation("Composite Call");
        //打印出所有的独立的享元对象，为系统设计过程提供辅助信息
        flyweightFactorySingleton.checkFlyweight();
    }
}
