package pr.tongson.pattern3.ObServer.other;

/**
 * <b>Description:</b> 具体主题 <br>
 */
public class ConcreteSubject extends Subject {
    private String state;

    /**
     * 调用这个方法更改主题的状态
     *
     * @param newState
     */
    public void change(String newState) {
        state = newState;
        this.notifyObservers();
    }
}
