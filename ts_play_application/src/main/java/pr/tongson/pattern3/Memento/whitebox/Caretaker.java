package pr.tongson.pattern3.Memento.whitebox;

/**
 * <b>Description:</b> 负责人角色 <br>
 */
public class Caretaker {
    private Memento mMemento;

    public Memento retrieveMemento() {
        return this.mMemento;
    }

    public void saveMemento(Memento memento) {
        this.mMemento = memento;
    }
}
