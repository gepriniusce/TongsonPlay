package pr.tongson.pattern.Prototype.register;

import java.util.Vector;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 原型管理器 <br>
 * 记录每一个被创建的对象
 */
public class PrototypeManager {
    private Vector objects = new Vector();

    /**
     * 聚集管理方法：增加一个新的对象
     *
     * @param object
     */
    public void add(Prototype object) {
        objects.add(object);
    }

    /**
     * 聚集管理方法：取出聚集中的一个对象
     *
     * @param i
     * @return
     */
    public Prototype get(int i) {
        return (Prototype) objects.get(i);
    }

    /**
     * 聚集管理方法：给出聚集的大小
     *
     * @return
     */
    public int getSize() {
        return objects.size();
    }
}
