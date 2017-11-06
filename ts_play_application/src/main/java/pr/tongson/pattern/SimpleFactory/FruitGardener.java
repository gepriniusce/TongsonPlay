package pr.tongson.pattern.SimpleFactory;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 工厂类Creator（上帝类God Class） <br>
 * 模式的核心。含有必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例。
 */
public class FruitGardener {

    public static Fruit factory(String which) throws BadFruitException {
        if (which.equalsIgnoreCase("apple")) {
            return new Apple();
        }
        if (which.equalsIgnoreCase("strawberry")) {
            return new Strawberry();

        }
        if (which.equalsIgnoreCase("grape")) {
            return new Grape();
        } else {
            throw new BadFruitException("");
        }
    }
}
