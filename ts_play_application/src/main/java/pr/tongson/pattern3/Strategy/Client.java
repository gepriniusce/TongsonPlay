package pr.tongson.pattern3.Strategy;

/**
 * <b>Create Date:</b> 2018/1/30<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategy());
        context.contextInterface();
    }
}
