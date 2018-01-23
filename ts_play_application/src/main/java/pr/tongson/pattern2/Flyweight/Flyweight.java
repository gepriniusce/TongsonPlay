package pr.tongson.pattern2.Flyweight;

/**
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
