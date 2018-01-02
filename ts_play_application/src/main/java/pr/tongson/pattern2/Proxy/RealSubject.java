package pr.tongson.pattern2.Proxy;

/**
 * <b>Description:</b>  <br>
 */
public class RealSubject extends Subject {

    /**
     * 构造子
     */
    public RealSubject() {
    }

    /**
     * 实现请求方法
     */
    @Override
    public void request() {
        System.out.println("From real subject.");
    }
}
