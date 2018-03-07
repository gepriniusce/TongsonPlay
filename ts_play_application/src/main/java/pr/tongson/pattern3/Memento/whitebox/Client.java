package pr.tongson.pattern3.Memento.whitebox;

/**
 * <b>Description:</b>  <br>
 */
public class Client {
    private static Originator o = new Originator();
    private static Caretaker c = new Caretaker();

    public static void main(String[] args) {
        //改变负责人对象的状态
        o.setState("On");
        //创建备忘录对象，并将发起人对象的状态存储起来
        c.saveMemento(o.createMemento());
        //修改发起人对象的状态
        o.setState("Off");
        //修复发起人对象的装填
        o.restoreMemento(c.retrieveMemento());
    }
}
