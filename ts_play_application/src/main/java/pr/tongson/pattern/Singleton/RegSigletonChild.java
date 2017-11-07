package pr.tongson.pattern.Singleton;

/**
 * <b>Create Date:</b> 2017/11/7<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class RegSigletonChild extends RegSingleton {
    public RegSigletonChild() {
    }

    static public RegSigletonChild getInstance() {
        return (RegSigletonChild) RegSingleton.getInstance("pr.tongson.pattern.Singleton.RegSigletonChild");
    }


    /**
     * 一些示意性的商业方法
     *
     * @return
     */
    @Override
    public String about() {
        return "Hello, I am RegSigletonChild.";
    }
}
