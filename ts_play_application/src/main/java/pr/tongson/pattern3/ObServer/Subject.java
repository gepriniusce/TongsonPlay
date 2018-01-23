package pr.tongson.pattern3.ObServer;


/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public interface Subject {
    /**
     * 调用这个方法登记一个新的观察者对象
     *
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * 调用这个方法删除一个已经登记过的观察者对象
     *
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 调用这个方法通知所有登记过的观察者对象
     */
    void notifyObservers();
}
