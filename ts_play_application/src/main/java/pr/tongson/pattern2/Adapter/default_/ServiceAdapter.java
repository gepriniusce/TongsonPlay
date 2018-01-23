package pr.tongson.pattern2.Adapter.default_;

/**
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
