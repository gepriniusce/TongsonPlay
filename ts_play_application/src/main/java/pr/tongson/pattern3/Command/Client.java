package pr.tongson.pattern3.Command;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Client {
    public static void main(String[] args){
        Receiver receiver=new Receiver();
        Command command=new ConcreteCommand(receiver);
        Invoker invoker=new Invoker(command);
        invoker.action();
    }
}
