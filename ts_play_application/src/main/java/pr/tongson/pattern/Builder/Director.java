package pr.tongson.pattern.Builder;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 导演者 <br>
 * 调用具体建造者以创建产品对象。
 */
public class Director {
    private Builder mBuilder;

    /**
     * 产品构造方法，负责调用各个零件构造方法
     */
    public void construct() {
        mBuilder = new ConcreteBuilder();
        mBuilder.buildPart1();
        mBuilder.buildPart2();
        mBuilder.retrieveResult();
        //continue with othor code
    }
}
