package pr.tongson.principle.isp.a;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public abstract class AbstractSearcher {

    protected PettyGirl mPettyGirl;
    protected IGoodBodyGirl mGoodBodyGirl;
    protected IGreatTemperamentGirl mGreatTemperamentGirl;

    public AbstractSearcher(PettyGirl pettyGirl) {
        mPettyGirl = pettyGirl;
    }

    public AbstractSearcher(IGoodBodyGirl goodBodyGirl) {
        mGoodBodyGirl = goodBodyGirl;
    }

    public AbstractSearcher(IGreatTemperamentGirl greatTemperamentGirl) {
        mGreatTemperamentGirl = greatTemperamentGirl;
    }

    //搜索美女，列出美女信息
    public abstract void show();
}