package pr.tongson.pattern3.Mediator;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Colleague1 extends Colleague {

    /**
     * 构造子，作为参量接收调停者对象
     *
     * @param mediator
     */
    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    /**
     * 行动方法的具体实现
     */
    @Override
    public void action() {
        System.out.println("This is an action from Colleague 1");
    }
}
