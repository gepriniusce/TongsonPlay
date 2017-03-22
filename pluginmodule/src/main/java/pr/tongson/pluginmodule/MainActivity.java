package pr.tongson.pluginmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pr.tongson.pluginmodule.dialog.TongsonGetPhotoDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        File dexOutputDir = getDir("dex1", 0);
//        String dexPath = Environment.getExternalStorageDirectory().toString() + File.separator + "output.dex";
//        DexClassLoader loader = new DexClassLoader(dexPath, dexOutputDir.getAbsolutePath(), null, getClassLoader());
//        try {
//            Class clz = loader.loadClass("pr.tongson.pluginmodule.ShowToastAndLog");
//            IShowToastAndLog impl = (IShowToastAndLog) clz.newInstance();
//            impl.showToast(this);
//            impl.showLog();
//        } catch (Exception e) {
//           Log.d("TongsonPlay", "error happened", e);
//        }


        Button fabuBtn = (Button) findViewById(R.id.btn_fabu);

        fabuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TongsonGetPhotoDialog dialog=new TongsonGetPhotoDialog(MainActivity.this);
                dialog.show();
            }
        });


    }
}
