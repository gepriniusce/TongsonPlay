package pr.tongson.pattern3.ObServer.java;


import java.util.Observer;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Tester {
    static private Watched watched;
    static private Observer watcher;

    public static void main(String[] args) {
        //创建被观察者对象
        watched = new Watched();
        //创建观察者对象，并将被观察者对象登记
        watcher = new Watcher(watched);
        //给被观察者对象的状态赋值4次
        watched.changeData("In C,we create bugs.");
        watched.changeData("In Java,we inherit bugs.");
        watched.changeData("In Java,we inherit bugs.");
        watched.changeData("In Visual Basic,we visualize bugs.");
    }
}
