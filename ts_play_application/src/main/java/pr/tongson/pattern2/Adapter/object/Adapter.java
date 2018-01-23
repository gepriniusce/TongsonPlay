package pr.tongson.pattern2.Adapter.object;

/**
 * <b>Description:</b> 适配器 <br>
 */
public class Adapter implements Target {

    private Adaptee mAdaptee;

    public Adapter(Adaptee adaptee) {
        mAdaptee = adaptee;
    }

    /**
     * 由于源类有方法sampleOpration2
     * 因此适配器类直接委派即可
     */
    @Override
    public void sampleOperation1() {
        mAdaptee.sampleOperation1();
    }

    /**
     * 由于源类没有方法sampleOpration2
     * 因此适配器类补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //write ur code here
    }
}
