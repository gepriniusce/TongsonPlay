package pr.tongson.principle.dp;

/**
 * <b>Create Date:</b> 2017/10/18<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class System implements ISystem {
    private void saveCurrentTask() {
        //do something
    }

    private void closeService() {
        //do something
    }

    private void closeScreen() {
        //do something
    }

    private void closePower() {
        //do something
    }

    @Override
    public void close() {
        saveCurrentTask();
        closeService();
        closeScreen();
        closePower();
    }
}
