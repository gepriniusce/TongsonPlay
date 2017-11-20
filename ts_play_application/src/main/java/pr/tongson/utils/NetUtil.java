package pr.tongson.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * <b>Create Date:</b> 2017/11/20<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class NetUtil {
    public static final String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    public NetUtil() {
    }

    public static NetworkInfo getActiveNetwork(Context context) {
        if(context == null) {
            return null;
        } else {
            ConnectivityManager mConnMgr = (ConnectivityManager)context.getSystemService("connectivity");
            if(mConnMgr == null) {
                return null;
            } else {
                return mConnMgr.getActiveNetworkInfo();
            }
        }
    }

    public static boolean hasNetWorkStatus(Context context, boolean needwifi) {
        NetworkInfo info = getActiveNetwork(context);
        return info != null && (!needwifi ? info.isAvailable() : info.getType() == 1 && info.isAvailable());
    }
}