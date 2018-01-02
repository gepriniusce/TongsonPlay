package pr.tongson.pattern2.Flyweight;

/**
 * <b>Description:</b> 具体享元 <br>
 */
public class ConcreteFlyweight extends Flyweight {

    private Character intrinsicState = null;

    /**
     * 构造子，内蕴状态作为参量传入
     *
     * @param state
     */
    public ConcreteFlyweight(Character state) {
        this.intrinsicState = state;
    }

    /**
     * 外蕴状态作为参量传入到方法中
     *
     * @param state
     */
    @Override
    public void operation(String state) {
        System.out.println("\nIntrinsicState state=" + intrinsicState + ",Extrinsic state=" + state);
    }
}
