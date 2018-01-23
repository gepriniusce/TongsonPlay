package pr.tongson.pattern3.ObServer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
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
