package pr.tongson.pattern2.Proxy;

/**
 * <b>Description:</b>  <br>
 */
public class ProxySubject extends Subject {

    private RealSubject mRealSubject;
    /**
     * 构造子
     */
    public ProxySubject() {
    }

    /**
     * 实现请求方法
     */
    @Override
    public void request() {
        preRequest();
        if (mRealSubject == null) {
            mRealSubject = new RealSubject();
        }
        mRealSubject.request();
        postRequest();
    }


    /**
     * 请求前的操作
     */
    private void preRequest() {

    }

    /**
     * 请求后的操作
     */
    private void postRequest() {

    }
}
