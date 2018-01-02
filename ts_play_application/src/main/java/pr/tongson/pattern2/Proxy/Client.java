package pr.tongson.pattern2.Proxy;

/**
 * <b>Description:</b>  <br>
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
