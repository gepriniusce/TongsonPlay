package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Description:</b> 货币市场账号 <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class MoneyMarketAccoount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045D;
    }
}
