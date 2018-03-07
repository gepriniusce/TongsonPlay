package pr.tongson.pattern3.Mediator;

/**
 * <b>Description:</b> 具体同事类 <br>
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
