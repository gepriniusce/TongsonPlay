package pr.tongson.principle.isp.a;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Client {
    //搜索并展示美女信息
    public static void main(String[] args) {
        //定义一个美女
        PettyGirl yanYan = new PettyGirl(" 嫣嫣");
        AbstractSearcher searcher = new Searcher(yanYan);
        searcher.show();
    }
}