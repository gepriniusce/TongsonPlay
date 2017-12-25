package pr.tongson.pattern2.Flyweight.Composite;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import pr.tongson.pattern2.Flyweight.ConcreteFlyweight;
import pr.tongson.pattern2.Flyweight.Flyweight;

/**
 * <b>Create Date:</b> 2017/12/20<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
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
     * 复合享元工厂方法，所需状态以参量形式传入
     * 这个参量可以使用String类型。
     * 也可以使用一个聚集，如Vector对象等。
     *
     * @param compositeState
     * @return
     */
    public Flyweight factory(String compositeState) {
        ConcreteCompositeFlyweight concreteCompositeFlyweight = new ConcreteCompositeFlyweight();
        int length = compositeState.length();
        Character state = null;
        for (int i = 0; i < length; i++) {
            state = new Character(compositeState.charAt(i));
            System.out.println("state(" + state + ")");
            concreteCompositeFlyweight.add(state, this.factory(state));
        }
        return concreteCompositeFlyweight;
    }

    /**
     * 单纯享元工厂方法，所需的状态以参量形式传入
     *
     * @param state
     * @return
     */
    public Flyweight factory(Character state) {
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
