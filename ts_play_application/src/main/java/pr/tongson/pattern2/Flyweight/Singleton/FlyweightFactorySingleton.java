package pr.tongson.pattern2.Flyweight.Singleton;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import pr.tongson.pattern2.Flyweight.ConcreteFlyweight;
import pr.tongson.pattern2.Flyweight.Flyweight;

/**
 * <b>Description:</b> 使用单例模式实现享元工厂角色 <br>
 */
public class FlyweightFactorySingleton {
    private HashMap files = new HashMap();

    private static FlyweightFactorySingleton myself = new FlyweightFactorySingleton();

    private FlyweightFactorySingleton() {

    }

    public static FlyweightFactorySingleton getInstance() {
        return myself;
    }


    /**
     * 工厂方法，向外界提供含有指定内蕴状态的对象
     *
     * @param state
     * @return
     */
    public synchronized Flyweight factory(Character state) {
        //检查具有此状态的享元是否已经存在
        if (files.containsKey(state)) {
            //具有此状态的享元已经存在，因此直接将它返还
            return (Flyweight) files.get(state);
        } else {
            //具有此状态的享元不存在，因此创建新实例
            Flyweight fly = new ConcreteFlyweight(state);
            //将实例存储到聚集中
            files.put(state, fly);
            //将实例返还
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
