package pr.tongson.pattern2.Composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * <b>Create Date:</b> 2017/12/13<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Composite implements Component {

    private Vector componentVector = new Vector();

    /**
     * 返回自己的实例
     *
     * @return this
     */
    @Override
    public Composite getComposite() {
        return this;
    }

    /**
     * 某个商业方法
     */
    @Override
    public void sampleOperation() {
        Enumeration enumeration = components();
        while (enumeration.hasMoreElements()) {
            ((Component) enumeration.nextElement()).sampleOperation();
        }
    }

    /**
     * 聚集管理方法，返还聚集的Enumeration对象
     *
     * @return
     */
    public Enumeration components() {
        return componentVector.elements();
    }

    /**
     * 聚集管理方法，增加一个子构件对象
     *
     * @param component
     */
    public void add(Component component) {
        componentVector.addElement(component);
    }

    /**
     * 聚集管理方法，删除一个子构件对象
     *
     * @param component
     */
    public void remove(Component component) {
        componentVector.removeElement(component);
    }


}
