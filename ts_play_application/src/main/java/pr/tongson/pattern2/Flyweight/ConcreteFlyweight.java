package pr.tongson.pattern2.Flyweight;

/**
 * <b>Create Date:</b> 2017/12/20<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class ConcreteFlyweight extends Flyweight{
    
    private Character intrinsicState=null;

    public ConcreteFlyweight(Character state) {
        this.intrinsicState = state;
    }

    @Override
    public void operation(String state) {
        
    }
}
