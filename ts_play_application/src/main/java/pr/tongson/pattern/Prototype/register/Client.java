package pr.tongson.pattern.Prototype.register;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 客户端 <br>
 * 客户端类向管理员提出创建对象的请求
 */
public class Client {
    private PrototypeManager mPrototypeManager;
    private Prototype mPrototype;

    public void registerPrototype() {
        mPrototype = new ConcretePrototype();
        Prototype copyType = (Prototype) mPrototype.clone();
        mPrototypeManager.add(copyType);
    }
}
