package pr.tongson.pattern3.Iterator.blackbox;

/**
 * <b>Description:</b> 客户端 <br>
 */
public class Client {
    private Iterator it;
    /**
     * 创建一个聚集类实例
     */
    private Aggregate agg = new ConcreteAggregate();

    public void opration() {
        //得到一个迭代子对象
        it = agg.createIterator();
        while (!it.isDone()) {
            System.out.println(it.currentItem().toString());
            it.next();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.opration();
    }
}
