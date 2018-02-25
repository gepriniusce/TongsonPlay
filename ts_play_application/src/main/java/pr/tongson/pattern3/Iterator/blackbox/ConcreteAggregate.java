package pr.tongson.pattern3.Iterator.blackbox;

/**
 * <b>Description:</b> 具体聚集角色 <br>
 * 黑箱聚集，不可能是不变对象。
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
