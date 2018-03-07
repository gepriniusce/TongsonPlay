package pr.tongson.pattern3.Mediator;

/**
 * <b>Description:</b> 抽象调停者类 <br>
 */
abstract public class Mediator {
    /**
     * 事件方法，由子类实现
     * @param colleague
     */
    abstract void colleagueChanged(Colleague colleague);

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.createConcreteMediator();
        Colleague c1 = new Colleague1(mediator);
        Colleague c2 = new Colleague2(mediator);
        mediator.colleagueChanged(c1);
    }
}
