package pr.tongson.pattern2.Composite;

/**
 * <b>Create Date:</b> 2017/12/13<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象控件 <br>
 */
public interface Component {
    /**
     * 返回自己的实例
     *
     * @return
     */
    Composite getComposite();

    /**
     * 某个商业方法
     */
    void sampleOperation();
}
