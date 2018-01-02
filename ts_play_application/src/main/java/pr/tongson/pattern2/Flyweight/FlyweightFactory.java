package pr.tongson.pattern2.Flyweight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <b>Description:</b> 享元工厂 <br>
 */
public class FlyweightFactory {
    private HashMap files = new HashMap();

    /**
     * 默认构造子
     */
    public FlyweightFactory() {
    }

    /**
     * 构造子，内蕴状态作为参量传入
     *
     * @param state
     * @return
     */
    public Flyweight factory(Character state) {
        if (files.containsKey(state)) {
            return (Flyweight) files.get(state);
        } else {
            Flyweight fly = new ConcreteFlyweight(state);
            files.put(state, fly);
            return fly;
        }
    }

    /**
     * 辅助方法，打印所有已经创建的享元对象清单
     */
    public void checkFlyweight() {
        int i = 0;
        System.out.println("\n==========checkFlyweight==========");
        for (Iterator it = files.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("Item" + (++i) + ":" + e.getKey());
        }
        System.out.println("\n==========checkFlyweight==========");
    }
}
