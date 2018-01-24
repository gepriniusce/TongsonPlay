package pr.tongson.pattern3.Memento.blackbox;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Originator {
    private String state;

    public Originator() {
    }
    public MementoIF createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(MementoIF memento) {
        Memento aMemento= (Memento) memento;
        this.state = aMemento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
