package pr.tongson.pattern3.Immutable;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 弱不变 <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class BClass {
    private int state = 0;

    public int getState() {
        return state;
    }

    public void setState(int aState) {
        System.out.println("Parameter is" + aState);
    }
}
