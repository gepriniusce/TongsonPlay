package pr.tongson.pattern3.ChainOfResponsibility;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ConcreteHandler extends Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    @Override
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println("The request is passed to " + getSuccessor());
            getSuccessor().handleRequest();
        } else {
            System.out.println("The request is handled here.");
        }
    }
}
