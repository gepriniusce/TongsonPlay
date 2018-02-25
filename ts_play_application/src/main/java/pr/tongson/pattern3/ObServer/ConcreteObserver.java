package pr.tongson.pattern3.ObServer;

/**
 * <b>Description:</b> 具体观察者 <br>
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
