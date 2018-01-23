package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
abstract public class Account {
    protected String accountNumber;

    public Account() {
        accountNumber = null;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * 模板方法，计算利息数额
     *
     * @return
     */
    final public double calculateInterest() {
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType, accountNumber);
        return amount * interestRate;
    }

    protected abstract String doCalculateAccountType();

    protected abstract double doCalculateInterestRate();

    final public double calculateAmount(String accountType, String accountNumber) {
        //retrieve amount from database...
        return 7243.00D;
    }
}
