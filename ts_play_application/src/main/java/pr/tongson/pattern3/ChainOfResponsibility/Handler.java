package pr.tongson.pattern3.ChainOfResponsibility;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class Handler {
    /**
     * 处理方法，调用此方法处理请求
     */
    protected Handler successor;

    public abstract void handleRequest();

    /**
     * 复制方法，调用此方法设定下家
     *
     * @param successor
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 取值方法
     *
     * @return
     */
    public Handler getSuccessor() {
        return successor;
    }
}
