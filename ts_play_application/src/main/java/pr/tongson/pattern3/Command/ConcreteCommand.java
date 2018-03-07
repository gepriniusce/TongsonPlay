package pr.tongson.pattern3.Command;

/**
 * <b>Description:</b> 具体命令 <br>
 */
public class ConcreteCommand implements Command {
    private Receiver mReceiver;

    public ConcreteCommand(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    public void execute() {
        mReceiver.action();
    }
}
