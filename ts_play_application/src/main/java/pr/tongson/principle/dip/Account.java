package pr.tongson.principle.dip;

/**
 * <b>Create Date:</b> 2017/10/9<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 聚合关系 <br>
 */
public class Account {
    
    /*聚合关系*/
    private AccountType mAccountType;
    
    /*聚合关系*/
    private AccountStatus mAccountStatus;

    public Account(AccountType accountType) {
    }

    public void deposit(float amt) {

    }

}
