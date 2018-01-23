package pr.tongson.pattern3.TemplateMethod;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ConcreteClass extends AbstractClass {
    /**
     * 基本方法的实现
     */
    @Override
    protected void doOperation1() {
        System.out.println("doOperation1();");
    }

    /**
     * 基本方法的实现
     */
    @Override
    protected void doOperation2() {
        System.out.println("doOperation2();");
    }
}
