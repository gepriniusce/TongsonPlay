package pr.tongson.pattern2.Bridge;

/**
 * <b>Create Date:</b> 2017/12/26<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
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
