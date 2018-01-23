package pr.tongson.pattern3.ObServer.other;

import pr.tongson.pattern3.ObServer.ConcreteObserver;
import pr.tongson.pattern3.ObServer.Observer;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Client {
    private static ConcreteSubject subject;
    private static Observer observer;

    public static void main(String[] args) {
        //创建主题对象
        subject = new ConcreteSubject();
        //创建观察者对象
        observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
    }
}
