package pr.tongson.pattern3.ObServer.java;

import java.util.Observable;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
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
