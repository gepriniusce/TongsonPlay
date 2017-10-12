package pr.tongson.principle.dip.b;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Client {
    public static void main(String[] args){
        Mother mother = new Mother();
        mother.narrate(new Book());
    }
}
