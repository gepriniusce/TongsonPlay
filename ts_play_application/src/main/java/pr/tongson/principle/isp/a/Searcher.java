package pr.tongson.principle.isp.a;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Searcher extends AbstractSearcher {
    public Searcher(PettyGirl girl) {
        super(girl);
    }

    public Searcher(IGoodBodyGirl girl) {
        super(girl);
    }

    public Searcher(IGreatTemperamentGirl girl) {
        super(girl);
    }


    @Override
    public void show() {
        System.out.println("--------美女的信息如下： ---------------");
        if (super.mPettyGirl != null) {
            //展示面容
            super.mPettyGirl.goodLooking();
            //展示身材
            super.mPettyGirl.niceFigure();
            //展示气质
            super.mPettyGirl.greatTemperament();
        }
        if (super.mGoodBodyGirl != null) {
            super.mGoodBodyGirl.goodLooking();
            super.mGoodBodyGirl.niceFigure();
        }
        if (super.mGreatTemperamentGirl != null) {
            super.mGreatTemperamentGirl.greatTemperament();
        }
    }
}
