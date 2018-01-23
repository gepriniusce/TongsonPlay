package pr.tongson.pattern3.Iterator.blackbox;

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
        return new ConcreteIterator();
    }

    /**
     * 内部成员类：具体迭代子类
     */
    private class ConcreteIterator implements Iterator {
        private int currentIndex = 0;

        @Override
        public void first() {
            currentIndex = 0;
        }

        @Override
        public void next() {
            if (currentIndex < mObjects.length) {
                currentIndex++;
            }
        }

        @Override
        public boolean isDone() {
            return currentIndex == mObjects.length;
        }

        @Override
        public Object currentItem() {
            return mObjects[currentIndex];
        }
    }
}
