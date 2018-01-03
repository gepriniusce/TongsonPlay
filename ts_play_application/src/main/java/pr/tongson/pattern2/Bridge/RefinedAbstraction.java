package pr.tongson.pattern2.Bridge;

/**
 * <b>Description:</b> 修正抽象化 <br>
 */
public class RefinedAbstraction extends Abstraction {
    /**
     * 某个商业方法修正抽象化角色的实现
     */
    @Override
    public void operation() {
        //improved logic
        System.out.println("operation improved logic...");

    }
}
