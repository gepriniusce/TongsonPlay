package pr.tongson.pattern3.ObServer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * <b>Description:</b> 观察者 <br>
 */
public class Watcher implements Observer {
    public Watcher(Watched w) {
        w.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Data has been changed to:" + ((Watched) o).retrieveData() + "");
    }
}
