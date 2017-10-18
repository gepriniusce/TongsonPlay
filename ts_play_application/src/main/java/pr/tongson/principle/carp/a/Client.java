package pr.tongson.principle.carp.a;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Client {

    public static void main(String[] args) {
        PhoneBrand phoneBrand;
        phoneBrand=new PhoneBrandA();
        phoneBrand.setPhoneBrand(new PhoneGame());
        phoneBrand.Run();
        phoneBrand.setPhoneBrand(new PhoneAddressList());
        phoneBrand.Run();
        phoneBrand=new PhoneBrandB();
        phoneBrand.setPhoneBrand(new PhoneGame());
        phoneBrand.Run();
        phoneBrand.setPhoneBrand(new PhoneAddressList());
        phoneBrand.Run();
    }
}
