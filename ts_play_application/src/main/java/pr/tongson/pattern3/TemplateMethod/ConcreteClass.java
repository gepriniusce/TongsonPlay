package pr.tongson.pattern3.TemplateMethod;

/**
 * <b>Description:</b> 具体模板 <br>
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
