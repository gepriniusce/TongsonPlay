package pr.tongson.pattern.Multition;

/**
 * <b>Create Date:</b> 2017/11/7<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Client {
    private static Die die1, die2;

    public static void main(String[] args) {
        die1 = Die.getInstance(1);
        die2 = Die.getInstance(2);
        die1.dice();
        die2.dice();
    }
}
