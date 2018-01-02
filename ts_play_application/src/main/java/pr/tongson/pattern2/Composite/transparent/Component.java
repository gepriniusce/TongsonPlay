package pr.tongson.pattern2.Composite.transparent;

import java.util.Enumeration;

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


    /**
     * 聚集管理方法，返还聚集的Enumeration对象
     *
     * @return
     */
    public Enumeration components();

    /**
     * 聚集管理方法，增加一个子构件对象
     *
     * @param component
     */
    public void add(Component component);

    /**
     * 聚集管理方法，删除一个子构件对象
     *
     * @param component
     */
    public void remove(Component component);
}
