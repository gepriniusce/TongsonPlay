package pr.tongson.pattern3.ObServer.java;

import java.util.Observable;

/**
 * <b>Description:</b> 被观察者 <br>
 */
public class Watched extends Observable {
    private String data = "";

    /**
     * 取值方法
     *
     * @return
     */
    public String retrieveData() {
        return data;
    }

    /**
     * 改值方法
     *
     * @return
     */
    public void changeData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }
}
