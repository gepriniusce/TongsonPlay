package pr.tongson.pattern3.Command;

/**
 * <b>Description:</b> 请求者 <br>
 */
public class Invoker {
    private Command mCommand;

    public Invoker(Command command) {
        mCommand = command;
    }

    /**
     * 行动方法
     */
    public void action()  {
        mCommand.execute();
    }
}
