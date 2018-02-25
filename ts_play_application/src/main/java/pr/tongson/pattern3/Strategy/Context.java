package pr.tongson.pattern3.Strategy;

/**
 * <b>Description:</b> 环境 <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Context {
    private Strategy mStrategy;

    public Context(Strategy strategy) {
        mStrategy = strategy;
    }

    /**
     * 策略方法
     */
    public void contextInterface() {
        mStrategy.strategyInterface();
    }
}
