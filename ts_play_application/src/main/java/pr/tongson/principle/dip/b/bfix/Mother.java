package pr.tongson.principle.dip.b.bfix;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Mother {
    public void narrate(IReader reader){
        System.out.println("妈妈开始讲故事");
        System.out.println(reader.getContent());
    }
}
