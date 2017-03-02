package pr.tongson.pluginmodule;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        File dexOutputDir = getDir("dex1", 0);
        String dexPath = Environment.getExternalStorageDirectory().toString() + File.separator + "output.dex";
        DexClassLoader loader = new DexClassLoader(dexPath, dexOutputDir.getAbsolutePath(), null, getClassLoader());
        try {
            Class clz = loader.loadClass("pr.tongson.pluginmodule.ShowToastAndLog");
            IShowToastAndLog impl = (IShowToastAndLog) clz.newInstance();
            impl.showToast(this);
            impl.showLog();
        } catch (Exception e) {
            Log.d("TongsonPlay", "error happened", e);
        }
    }
}
