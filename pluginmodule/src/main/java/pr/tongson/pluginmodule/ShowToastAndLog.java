package pr.tongson.pluginmodule;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/2<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class ShowToastAndLog implements IShowToastAndLog {

    @Override
    public void showToast(Context context) {
        Toast.makeText(context, "我来自另一个dex文件", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLog() {
        Log.i("TongsonPlay", "我来自另一个dex文件");
    }
}
