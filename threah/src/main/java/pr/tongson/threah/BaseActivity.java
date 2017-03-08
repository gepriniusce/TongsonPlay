package pr.tongson.threah;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/3<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class BaseActivity extends AppCompatActivity {

    public String TAG="TongsonPlay";
    
    public boolean isMainThread() {
        Log.i(TAG, "isMainThread:" + (Looper.getMainLooper() == Looper.myLooper()));
        return Looper.getMainLooper() == Looper.myLooper();
    }
    //    public boolean isMainThread() {
    //        return Looper.getMainLooper().getThread() == Thread.currentThread();
    //    }
    //    public boolean isMainThread() {
    //        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    //    }
}
