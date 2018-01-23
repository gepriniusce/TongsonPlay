package pr.tongson.pattern3.Iterator.blackbox;

/**
 * <b>Create Date:</b> 2018/1/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public interface Iterator {
    /**
     * 迭代方法：移动到第一个元素
     */
    void first();

    /**
     * 迭代方法：移动到下一个元素
     */
    void next();

    /**
     * 迭代方法：是否是最后一个元素
     */
    boolean isDone();

    /**
     * 迭代方法：返还当前元素
     */
    Object currentItem();
}
