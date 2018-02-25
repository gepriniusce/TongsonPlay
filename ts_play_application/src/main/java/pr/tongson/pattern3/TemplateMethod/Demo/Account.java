package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Description:</b> 抽象模板 <br>
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

    /**
     * 计算账户类型
     *
     * @return
     */
    protected abstract String doCalculateAccountType();

    /**
     * 计算利率
     *
     * @return
     */
    protected abstract double doCalculateInterestRate();

    /**
     * 计算金额
     *
     * @param accountType
     * @param accountNumber
     * @return
     */
    final public double calculateAmount(String accountType, String accountNumber) {
        //retrieve amount from database...
        return 7243.00D;
    }
}
