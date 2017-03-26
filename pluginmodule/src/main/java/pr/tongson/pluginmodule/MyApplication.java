package pr.tongson.pluginmodule;

import android.app.Application;

import static pr.tongson.pluginmodule.type.TTFUtils.loadTtf;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/24<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class MyApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        loadTtf(getApplicationContext());

    }
}
