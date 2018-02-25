package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Description:</b>  <br>
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
