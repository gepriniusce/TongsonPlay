package pr.tongson.pattern.AbstractFactory;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体工厂类 <br>
 */
public class TropicalGardener implements Gardener{
    @Override
    public Fruit createFruit(String name) {
        return new TropicalFruit(name);
    }

    @Override
    public Veggie createVeggie(String name) {
        return new TropicalVeggic(name);
    }
}
