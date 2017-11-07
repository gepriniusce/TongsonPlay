package pr.tongson.pattern.Singleton;

/**
 * <b>Create Date:</b> 2017/11/7<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 懒汉式单例类 <br>
 * 懒汉式单例类在实例化时，必须处理好在多个线程同时抽次引用此类时访问限制问题，特别是当单例类作为资源控制器在实例化时必然涉及资源初始化，而资源初始化很有可能耗费时间。
 * 这意味着出现多线程同时首次引用此类的几率变得较大。
 * 
 * 不可继承
 */
public class LazySingleton {
    private static LazySingleton mInstance = null;

    /**
     * 私有的默认构造子，保证外界无法直接实例化
     */
    private LazySingleton() {
    }

    /**
     * 静态工厂方法，返还此类的唯一实例
     *
     * @return
     */
    synchronized public static LazySingleton getInstance() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

}
