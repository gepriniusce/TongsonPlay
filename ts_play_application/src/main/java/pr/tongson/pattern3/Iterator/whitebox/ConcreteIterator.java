package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
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
