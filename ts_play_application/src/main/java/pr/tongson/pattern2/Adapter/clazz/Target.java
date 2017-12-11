package pr.tongson.pattern2.Adapter.clazz;

/**
 * <b>Create Date:</b> 2017/12/11<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 目标 <br>
 */
public interface Target {

    /**
     * 这是源类也有的方法sampleOperation1
     */
    void sampleOperation1();
    /**
     * 这是源类没有的方法sampleOperation2
     */
    void sampleOperation2();
    
}
