package pr.tongson.pattern3.Mediator;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 抽象同事类 <br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class Colleague {
    private Mediator mMediator;

    public Colleague(Mediator mediator) {
        mMediator = mediator;
    }

    /**
     * 取值方法，提供调停者对象
     *
     * @return
     */
    public Mediator getMediator() {
        return mMediator;
    }

    /**
     * 行动方法，由子类实现
     */
    public abstract void action();

    /**
     * 示意性的商业方法，调用此方法可以改变对象的内部状态
     */
    public void change() {
        mMediator.colleagueChanged(this);
    }
}
