package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Description:</b> 具体迭代子角色 <br>
 * 向外界提供访问自己内部元素的接口（称做遍历方法或者Traversing Method），从而使外禀迭代子可以通过聚集遍历方法实现迭代功能。
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate agg;
    private int index = 0;
    private int size = 0;

    /**
     * 构造子
     *
     * @param agg
     */
    public ConcreteIterator(ConcreteAggregate agg) {
        this.agg = agg;
        this.index = 0;
        this.size = agg.size();
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if (index < size) {
            index++;
        }
    }

    @Override
    public boolean isDone() {
        return (index >= size);
    }

    @Override
    public Object currentItem() {
        return agg.getElement(index);
    }
}
