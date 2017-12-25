package pr.tongson.pattern2.Flyweight;

/**
 * <b>Create Date:</b> 2017/12/20<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象享元 <br>
 */
abstract public class Flyweight {
    /**
     * 外蕴状态作为参量传入到方法中
     *
     * @param state
     */
    abstract public void operation(String state);
}
