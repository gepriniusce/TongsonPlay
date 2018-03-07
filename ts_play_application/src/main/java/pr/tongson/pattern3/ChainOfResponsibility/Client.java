package pr.tongson.pattern3.ChainOfResponsibility;

/**
 * <b>Description:</b>  <br>
 */
public class Client {
    static private Handler handler1, handler2;

    public static void main(String[] args) {
        handler1 = new ConcreteHandler();
        handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        handler1.handleRequest();
    }
}
