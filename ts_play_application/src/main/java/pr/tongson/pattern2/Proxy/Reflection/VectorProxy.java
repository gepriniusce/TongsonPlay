package pr.tongson.pattern2.Proxy.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**
 * <b>Description:</b> 一个例子 <br>
 */
public class VectorProxy implements InvocationHandler {

    private Object proxyObj;

    public VectorProxy(Object proxyObj) {
        this.proxyObj = proxyObj;
    }


    /**
     * 静态工厂方法
     *
     * @param obj
     * @return
     */
    public static Object factory(Object obj) {
        Class cls = obj.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new VectorProxy(obj));
    }

    /**
     * 调用某个方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling" + method);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i] + "");
            }
        }
        Object o = method.invoke(proxyObj, args);
        System.out.println("after calling" + method);
        return o;
    }

    public static void main(String[] args) {
        List v = null;
        v = (List) factory(new Vector(10));
        v.add("New");
        v.add("York");
    }
}
