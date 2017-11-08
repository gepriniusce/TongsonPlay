package pr.tongson.pattern.Builder;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象建造者 <br>
 * 给出一个抽象接口，以规范产品对象的各个组成成分的建造。
 * 一般而言，此接口独立于应用程序的商业逻辑。
 */
abstract public class Builder {
    /**
     * 产品零件建造方法
     */
    public abstract void buildPart1();

    /**
     * 产品零件建造方法
     */
    public abstract void buildPart2();

    /**
     * 产品返还方法
     *
     * @return
     */
    public abstract Product retrieveResult();
}
