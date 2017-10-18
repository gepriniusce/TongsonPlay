package pr.tongson.principle.carp.a;

/**
 * <b>Create Date:</b> 2017/10/18<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 手机品牌 <br>
 */
public abstract class PhoneBrand {
    protected PhoneSoft mPhoneSoft;

    public void setPhoneBrand(PhoneSoft phoneSoft) {
        mPhoneSoft = phoneSoft;
    }

    public abstract void Run();
}
