package pr.tongson.pattern.Builder;

/**
 * <b>Create Date:</b> 2017/11/8<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体建造者 <br>
 * 创建产品实例
 */
public class ConcreteBuilder extends Builder {
    private Product mProduct = new Product();

    /**
     * 产品零件建造方法
     */
    @Override
    public void buildPart1() {
        //build the first part of the product
    }

    /**
     * 产品零件建造方法
     */
    @Override
    public void buildPart2() {
        //build the second part of the product
    }

    /**
     * 产品返还方法
     *
     * @return
     */
    @Override
    public Product retrieveResult() {
        return mProduct;
    }

}
