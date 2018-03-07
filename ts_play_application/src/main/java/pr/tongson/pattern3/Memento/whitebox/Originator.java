package pr.tongson.pattern3.Memento.whitebox;

/**
 * <b>Description:</b> 发起人角色 <br>
 */
public class Originator {
    private String state;

    public Memento createMemento() {
        //返回一个新的备忘录对象
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        //将发起人恢复到备忘录对象所记载的状态
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("Current state=" + this.state);
    }
}
