package pr.tongson.pattern.FactoryMethod;

import pr.tongson.pattern.SimpleFactory.Fruit;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象工厂Creator <br>
 * 模式的核心。
 */
public interface FruitGardener {
    Fruit factory();
}
