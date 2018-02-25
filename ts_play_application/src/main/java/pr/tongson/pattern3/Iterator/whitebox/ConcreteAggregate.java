package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Description:</b> 具体聚集角色 <br>
 * 白箱聚集，可以是不变对象。
 */
public class ConcreteAggregate extends Aggregate {

    /**
     * 聚集对象。类被加载时就被初始化的。在被加载后，聚集的元素就不再变化。
     */
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
