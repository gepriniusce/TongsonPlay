package pr.tongson.pattern3.State.tcp;

/**
 * <b>Create Date:</b> 2018/1/24<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class TcpConnection {
    private TcpState mTcpState;

    public void setTcpState(TcpState tcpState) {
        mTcpState = tcpState;
    }

    public void open(){
        mTcpState.open();
    }
    public void close(){
        mTcpState.close();
    }
    public void acknowledge(){
        mTcpState.acknowledge();
    }
    
}
