package pr.tongson.pattern.Prototype;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 客户 <br>
 * 提出创建对象的请求
 */
public class Client {
    private Prototype mPrototype;

    public void operation(Prototype example) {
        Prototype copytype = example.clone();
    }
}
