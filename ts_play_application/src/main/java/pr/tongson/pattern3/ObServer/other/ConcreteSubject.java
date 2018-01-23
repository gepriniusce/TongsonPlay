package pr.tongson.pattern3.ObServer.other;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
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
