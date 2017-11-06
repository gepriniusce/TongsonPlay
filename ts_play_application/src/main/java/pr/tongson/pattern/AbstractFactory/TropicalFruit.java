package pr.tongson.pattern.AbstractFactory;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体产品类 <br>
 */
public class TropicalFruit implements Fruit {

    private String name;

    public TropicalFruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
