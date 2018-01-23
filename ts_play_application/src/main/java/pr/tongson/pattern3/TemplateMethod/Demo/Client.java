package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Client {
    private static Account account = null;

    public static void main(String[] args) {
        account = new MoneyMarketAccoount();
        System.out.println("Interest from Money Market account" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("Interest from CD account" + account.calculateInterest());

    }
}
