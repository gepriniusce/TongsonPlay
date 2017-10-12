package pr.tongson.principle.ocp.b;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 打折的书 <br>
 */
public class OffNovelBook extends NovelBook {
    public OffNovelBook(String name, int price, String author) {
        super(name, price, author);
    }

    @Override
    public int getPrice() {
        int selfPrice = super.getPrice();
        int offPrice = 0;
        if (selfPrice > 4000) {
            offPrice = selfPrice * 90 / 100;
        } else {
            offPrice = selfPrice * 80 / 100;
        }
        return offPrice;
    }
}
