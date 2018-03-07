package pr.tongson.pattern3.Command;

/**
 * <b>Description:</b> 客户 <br>
 */
public class Client {
    public static void main(String[] args){
        Receiver receiver=new Receiver();
        Command command=new ConcreteCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.action();
    }
}
