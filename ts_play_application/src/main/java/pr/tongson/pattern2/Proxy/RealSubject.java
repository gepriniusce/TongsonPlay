package pr.tongson.pattern2.Proxy;

import android.util.Log;

/**
 * <b>Create Date:</b> 2017/12/20<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
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
        Log.i("Tongson","From real subject.");
    }
}
