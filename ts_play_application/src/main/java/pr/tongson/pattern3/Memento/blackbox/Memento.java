package pr.tongson.pattern3.Memento.blackbox;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Memento implements MementoIF{
    private String saveState;

    public Memento(String someState) {
        this.saveState = someState;
    }

    public String getState() {
        return saveState;
    }

    public void setState(String someState) {
        this.saveState = someState;
    }
}
