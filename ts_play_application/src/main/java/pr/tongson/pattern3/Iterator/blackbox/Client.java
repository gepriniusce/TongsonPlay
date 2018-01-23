package pr.tongson.pattern3.Iterator.blackbox;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Client {
    private Iterator it;
    private Aggregate agg = new ConcreteAggregate();

    public void opration() {
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
