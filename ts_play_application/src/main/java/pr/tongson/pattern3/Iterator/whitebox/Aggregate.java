package pr.tongson.pattern3.Iterator.whitebox;

/**
 * <b>Description:</b> 抽象聚集角色 <br>
 */
abstract public class Aggregate {
    /**
     * 工厂方法：返还一个迭代子对象
     *
     * @return
     */
    public Iterator createIterator() {
        return null;
    }
}
