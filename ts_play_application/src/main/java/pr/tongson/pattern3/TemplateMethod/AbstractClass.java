package pr.tongson.pattern3.TemplateMethod;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class AbstractClass {

    /**
     * 模板方法的声明和实现
     */
    public void TemplateMethod() {
        //调用基本方法（由子类实现）
        doOperation1();
        //调用基本方法（由子类实现）
        doOperation2();
        //调用基本方法（已实现）
        doOperation3();
    }

    /**
     * 基本方法的声明（由子类实现）
     */
    protected abstract void doOperation1();

    /**
     * 基本方法的声明（由子类实现）
     */
    protected abstract void doOperation2();

    /**
     * 基本方法（已实现）
     */
    private final void doOperation3(){
        
    }

}
