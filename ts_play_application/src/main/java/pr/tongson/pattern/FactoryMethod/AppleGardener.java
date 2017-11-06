package pr.tongson.pattern.FactoryMethod;

import pr.tongson.pattern.SimpleFactory.Apple;
import pr.tongson.pattern.SimpleFactory.Fruit;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体工厂Concrete Creator <br>
 */
public class AppleGardener implements FruitGardener {
    @Override
    public Fruit factory() {
        return new Apple();
    }
}
