package pr.tongson.pattern.Singleton;

import java.util.HashMap;

/**
 * <b>Create Date:</b> 2017/11/7<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 登记式单例类 <br>
 * 饿汉式
 * 可继承
 */
public class RegSingleton {
    static private HashMap mRegistry = new HashMap();

    static {
        RegSingleton x = new RegSingleton();
        mRegistry.put(x.getClass().getName(), x);
    }

    /**
     * 保护的默认构造子
     */
    protected RegSingleton() {

    }

    /**
     * 静态工厂方法，返还此类的唯一实例
     *
     * @param name
     * @return
     */
    static public RegSingleton getInstance(String name) {
        if (name == null) {
            name = "pr.tongson.pattern.Singleton.RegSingleton";
        }
        if (mRegistry.get(name) == null) {
            try {
                mRegistry.put(name, Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        return (RegSingleton) mRegistry.get(name);
    }

    /**
     * 一些示意性的商业方法
     *
     * @return
     */
    public String about() {
        return "Hello, I am RegSigleton.";
    }
}
