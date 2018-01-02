package pr.tongson.pattern2.Flyweight.Composite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import pr.tongson.pattern2.Flyweight.Flyweight;

/**
 * <b>Description:</b> 具体复合享元角色 <br>
 */
public class ConcreteCompositeFlyweight extends Flyweight {
    private HashMap files = new HashMap(10);
    private Flyweight mFlyweight;

    /**
     * 默认构造子
     */
    public ConcreteCompositeFlyweight() {
    }

    /**
     * 增加一个新的单纯响元对象到聚集中
     *
     * @param key
     * @param fly
     */
    public void add(Character key, Flyweight fly) {
        files.put(key, fly);
    }

    /**
     * 外蕴状态作为参量传入到方法中
     *
     * @param state
     */
    @Override
    public void operation(String state) {
        Flyweight flyweight = null;
        for (Iterator iterator = files.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (Map.Entry) iterator.next();
            flyweight = (Flyweight) entry.getValue();
            flyweight.operation(state);
        }
    }
}
