package pr.tongson.principle.isp.a;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class PettyGirl implements IGoodBodyGirl, IGreatTemperamentGirl {
    private String name;

    public PettyGirl(String name) {
        this.name = name;
    }

    //脸蛋漂亮
    public void goodLooking() {
        System.out.println(this.name + "---脸蛋很漂亮!");
    }

    //气质要好
    public void greatTemperament() {
        System.out.println(this.name + "---气质非常好!");
    }

    //身材要好
    public void niceFigure() {
        System.out.println(this.name + "---身材非常棒!");
    }
}