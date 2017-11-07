package pr.tongson.pattern.Multition;

import java.util.Date;
import java.util.Random;

/**
 * <b>Create Date:</b> 2017/11/7<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class Die {
    private static Die die1 = new Die();
    private static Die die2 = new Die();

    /**
     * 私有的构造子保证外界无法直接将此类实例化
     */
    private Die() {
    }

    /**
     * 工厂方法
     *
     * @param whichOne
     * @return
     */
    public static Die getInstance(int whichOne) {
        if (whichOne == 1) {
            return die1;
        } else {
            return die2;
        }
    }

    /**
     * 掷骰子，返回一个在1~6之间的随机数
     *
     * @return
     */
    public synchronized int dice() {
        Date date = new Date();
        Random random = new Random(date.getTime());
        int value = random.nextInt();
        value = Math.abs(value);
        value = value % 6;
        value += 1;
        return value;
    }
}
