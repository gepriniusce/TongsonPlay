package pr.tongson.pattern3.Command;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
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
