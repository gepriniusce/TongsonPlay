package pr.tongson.pattern3.ObServer;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ConcreteObserver implements Observer {
    /**
     * 调用这个方法会更新自己
     */
    @Override
    public void update() {
        System.out.println("I am notified");
    }
}
