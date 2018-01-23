package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ConcreteAggregate extends Aggregate {
    private Object[] mObjects = {"Monk Tang", "Monkey", "Pigsy", "Sandy", "Horse"};

    /**
     * 工厂方法：返还一个迭代子对象
     *
     * @return
     */
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    /**
     * 取值方法：向外界提供聚集元素
     *
     * @param index
     * @return
     */
    public Object getElement(int index) {
        if (index < mObjects.length) {
            return mObjects[index];
        } else {
            return null;
        }
    }

    /**
     * 取值方法：向外界提供聚集的大小
     *
     * @return
     */
    public int size() {
        return mObjects.length;
    }
}
