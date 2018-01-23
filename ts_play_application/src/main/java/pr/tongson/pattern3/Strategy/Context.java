package pr.tongson.pattern3.Strategy;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Context {
    private Strategy mStrategy;

    public void contextInterface() {
        mStrategy.strategyInterface();
    }
}
