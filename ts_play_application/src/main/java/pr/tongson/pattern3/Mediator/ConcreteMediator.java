package pr.tongson.pattern3.Mediator;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 具体调停者类 <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ConcreteMediator extends Mediator {
    private Colleague1 mColleague1;
    private Colleague2 mColleague2;

    /**
     * 事件方法的具体实现
     *
     * @param colleague
     */
    @Override
    public void colleagueChanged(Colleague colleague) {
        mColleague1.action();
        mColleague2.action();
    }

    /**
     * 工厂方法，创建同事对象
     */
    public void createConcreteMediator() {
        mColleague1 = new Colleague1(this);
        mColleague2 = new Colleague2(this);
    }

    /**
     * 取值方法，提供同事对象
     *
     * @return
     */
    public Colleague1 getColleague1() {
        return mColleague1;
    }

    /**
     * 取值方法，提供同事对象
     *
     * @return
     */
    public Colleague2 getColleague2() {
        return mColleague2;
    }
}
