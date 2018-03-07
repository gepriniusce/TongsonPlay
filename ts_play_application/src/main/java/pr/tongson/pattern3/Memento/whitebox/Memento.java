package pr.tongson.pattern3.Memento.whitebox;

/**
 * <b>Description:</b> 备忘录角色 <br>
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
