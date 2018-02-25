package pr.tongson.pattern3.ObServer;


/**
 * <b>Description:</b> 抽象主题 <br>
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
