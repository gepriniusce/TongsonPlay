package pr.tongson.pattern.AbstractFactory;


/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象工厂 <br>
 * 模式的核心。
 * 1.一个系统不应当依赖于产品类的实例如何被创建、组合和表达的细节。（所有工厂模式）
 * 2.这个系统的产品有多余一个的产品族，而系统只消费其中某一个产品族的产品。（原始用意）
 * 3.同属于同一个产品族的产品是在一起使用的，这一约束必须在系统的设计中体现出来。
 * 4.系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于实现。
 */
public interface Gardener {
    Fruit createFruit(String name);

    Veggie createVeggie(String name);
}
