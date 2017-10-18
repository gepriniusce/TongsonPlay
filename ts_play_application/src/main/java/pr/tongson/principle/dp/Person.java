package pr.tongson.principle.dp;

/**
 * <b>Create Date:</b> 2017/10/18<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Person {

    private IContainer c;

    //......
    
    public void clickCloseButton() {
        c.sendCloseCommand();
    }
}
