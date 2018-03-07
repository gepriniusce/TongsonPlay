package pr.tongson.pattern3.ChainOfResponsibility;

/**
 * <b>Description:</b> 具体处理者 <br>
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
