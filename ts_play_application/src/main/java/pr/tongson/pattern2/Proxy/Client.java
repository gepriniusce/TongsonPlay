package pr.tongson.pattern2.Proxy;

/**
 * <b>Create Date:</b> 2017/12/19<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
