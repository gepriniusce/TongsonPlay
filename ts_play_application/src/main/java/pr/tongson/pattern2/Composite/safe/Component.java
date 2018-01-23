package pr.tongson.pattern2.Composite.safe;

/**
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
