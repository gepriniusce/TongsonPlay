package pr.tongson.pattern2.Adapter.default_;

/**
 * <b>Create Date:</b> 2017/12/12<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 三个方法都提供了平庸实现 <br>
 */
public class ServiceAdapter implements AbstractService {
    @Override
    public void serviceOperation1() {
        
    }

    @Override
    public int serviceOperation2() {
        return 0;
    }

    @Override
    public String serviceOperation3() {
        return null;
    }
}
