package pr.tongson.pattern2.Adapter.clazz;

/**
 * <b>Create Date:</b> 2017/12/11<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 适配器 <br>
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 由于源类没有方法sampleOpration2
     * 因此适配器类补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //write ur code here
    }
}
