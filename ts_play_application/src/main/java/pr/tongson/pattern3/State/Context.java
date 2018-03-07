package pr.tongson.pattern3.State;

/**
 * <b>Description:</b> 环境类 <br>
 */
public class Context {
    private State mState;

    public void sampleOperation() {
        mState.sampleOperation();
    }

    public void setState(State state) {
        mState = state;
    }
}
