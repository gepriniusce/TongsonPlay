package pr.tongson.pattern2.Adapter.object;

/**
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
