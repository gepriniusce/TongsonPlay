package pr.tongson.pattern.Singleton;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 饿汉式单例类 <br>
 * 饿汉式单例类在自己被加载时将自己实例化。
 * 即便加载器是静态的，在饿汉式单例类加载时仍会将自己实例化。
 * 单从资源利用率角度来讲，这个比懒汉式单例类稍差些。
 * 从速度和反应时间角度来讲，则比懒汉式单例类稍好些。
 * 
 * 不可继承
 */
public class EagerSingleton {

    private static final EagerSingleton mInstance = new EagerSingleton();

    /**
     * 私有的默认构造子
     */
    private EagerSingleton() {
    }

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static EagerSingleton getInstance() {
        return mInstance;
    }
}
