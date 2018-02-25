package pr.tongson.pattern3.TemplateMethod.Demo;

/**
 * <b>Description:</b> 定期存款账号 <br>
 * Certificate of Deposite
 */
public class CDAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.065D;
    }
}
