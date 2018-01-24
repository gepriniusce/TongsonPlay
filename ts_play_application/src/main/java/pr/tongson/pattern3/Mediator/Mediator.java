package pr.tongson.pattern3.Mediator;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class Mediator {
    abstract void colleagueChanged(Colleague colleague);

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.createConcreteMediator();
        Colleague c1 = new Colleague1(mediator);
        Colleague c2 = new Colleague2(mediator);
        mediator.colleagueChanged(c1);
    }
}
