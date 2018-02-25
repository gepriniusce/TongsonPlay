package pr.tongson.pattern3.ObServer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <b>Description:</b> 具体主题 <br>
 */
public class ConcreteSubject implements Subject {
    private Vector observersVector = new Vector();

    /**
     * 调用这个方法登记一个新的观察者对象
     *
     * @param observer
     */
    @Override
    public void attach(Observer observer) {
        observersVector.addElement(observer);
    }

    /**
     * 调用这个方法删除一个已经登记过的观察者对象
     *
     * @param observer
     */
    @Override
    public void detach(Observer observer) {
        observersVector.removeElement(observer);
    }

    /**
     * 调用这个方法通知所有登记过的观察者对象
     */
    @Override
    public void notifyObservers() {
        Enumeration enumeration = observers();
        while (enumeration.hasMoreElements()) {
            ((Observer) enumeration.nextElement()).update();
        }
    }

    /**
     * 这个方法给出观察者聚集的Enumeration对象
     *
     * @return
     */
    private Enumeration observers() {
        return ((Vector) observersVector.clone()).elements();
    }
}
