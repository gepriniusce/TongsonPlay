package pr.tongson.pattern3.Memento.blackbox;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Caretaker {
    private MementoIF mMemento;

    public MementoIF retrieveMemento() {
        return this.mMemento;
    }

    public void saveMementto(MementoIF memento) {
        this.mMemento = memento;
    }
}
