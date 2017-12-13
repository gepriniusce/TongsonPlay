package pr.tongson.pattern2.Composite.safe;

import java.util.Enumeration;

/**
 * <b>Create Date:</b> 2017/12/13<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Leaf implements Component {
    /**
     * 返回自己的实例
     *
     * @return this
     */
    @Override
    public Composite getComposite() {
        //Write ur code here
        return null;
    }

    /**
     * 某个商业方法
     */
    @Override
    public void sampleOperation() {
        //Write ur code here
    }

    @Override
    public Enumeration components() {
        return null;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }
}
