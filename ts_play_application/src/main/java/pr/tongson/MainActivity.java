package pr.tongson;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tinkerpatch.sdk.TinkerPatch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mainActivity;
    private ImageView ivL1;
    private ImageView ivL2;
    private ImageView ivCenter;
    private ImageView ivR1;
    private ImageView ivR2;
    private TextView showMessageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = (LinearLayout) findViewById(R.id.activity_main);
        ivL1 = (ImageView) findViewById(R.id.left_1_iv);
        ivL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivL1,hight:" + ivL1.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        ivL2 = (ImageView) findViewById(R.id.left_2_iv);
        ivL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivL2,hight:" + ivL2.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        ivCenter = (ImageView) findViewById(R.id.center_iv);
        ivCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivCenter,hight:" + ivCenter.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        ivR1 = (ImageView) findViewById(R.id.right_1_iv);
        ivR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivR1,hight:" + ivR1.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        ivR2 = (ImageView) findViewById(R.id.right_2_iv);
        ivR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ivR2,hight:" + ivR2.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });


        Button catchPatchBtn = (Button) findViewById(R.id.catch_patch);
        Button testBtn = (Button) findViewById(R.id.test);
        Button cleanPatchBtn = (Button) findViewById(R.id.clean_patch);
        Button cleanMessageBtn = (Button) findViewById(R.id.clean_message);
        Button closeBtn = (Button) findViewById(R.id.close);
        showMessageTv = (TextView) findViewById(R.id.show_massage);
                showMessageTv.setText("原版包");
//        showMessageTv.setText("补丁包咯");
        catchPatchBtn.setOnClickListener(this);
        testBtn.setOnClickListener(this);
        cleanPatchBtn.setOnClickListener(this);
        cleanMessageBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.catch_patch:
                if (Build.VERSION.SDK_INT >= 23) {
                    requestExternalStoragePermission();
                } else {
                    fetchPatch();
                }
                break;
            case R.id.test:
                showInfo(MainActivity.this);
                break;
            case R.id.clean_patch:
                TinkerPatch.with().cleanPatch();
                showMessageTv.setText("清除补丁");
                break;
            case R.id.clean_message:
                //                showMessageTv.setText("BuildConfig.VERSION_NAME:" + BuildConfig.VERSION_NAME + "\n" + "baseInfo:" + getString(R.string.baseInfo) + "\n信息已清除"+"\n"
                //                        
                ////                +"REPORT_CRASHES:"+BuildConfig.REPORT_CRASHES+"\n"
                ////                +"channel:"+BuildConfig.channel+"\n"
                ////                +"BUILD_TYPE:"+BuildConfig.BUILD_TYPE+"\n"
                ////                +"baseInfo:"+BuildConfig.BASE_INFO+"\n"
                //                        
                //                );
                showMessageTv.setText("BuildConfig.VERSION_NAME:" + BuildConfig.VERSION_NAME + "\n" + "BuildConfig.BASE_INFO:" + BuildConfig.BASE_INFO + "\n信息已清除");

                break;
            case R.id.close:
                ShareTinkerInternals.killAllOtherProcess(getApplicationContext());
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
        }
    }


    private static final int REQUEST_EXTERNAL_STORAGE_PERMISSION = 0;

    /**
     * 如果本地补丁放在了外部存储卡中, 6.0以上需要申请读外部存储卡权限才能够使用. 应用内部存储则不受影响
     */
    private void requestExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "权限通过", Toast.LENGTH_SHORT).show();
                    fetchPatch();
                }
                break;
            default:
        }
    }

    private void fetchPatch() {
        TinkerPatch.with().fetchPatchUpdate(true);
        showMessageTv.setText("id:" + android.os.Process.myPid() + ";发送请求，访问服务器，更新");
    }

    public boolean showInfo(Context context) {
        // add more Build Info
        final StringBuilder sb = new StringBuilder();
        Tinker tinker = Tinker.with(getApplicationContext());
        if (tinker.isTinkerLoaded()) {
            sb.append(String.format("[patch is loaded] \n"));
            //            sb.append(String.format("[buildConfig TINKER_ID] %s \n", BuildConfig.TINKER_ID));
            //            sb.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", BaseBuildInfo.BASE_TINKER_ID));
            //            sb.append(String.format("[buildConfig MESSSAGE] %s \n", BuildInfo.MESSAGE));
            sb.append(String.format("[TINKER_ID] %s \n", tinker.getTinkerLoadResultIfPresent().getPackageConfigByName(ShareConstants.TINKER_ID)));
            sb.append(String.format("[packageConfig patchMessage] %s \n", tinker.getTinkerLoadResultIfPresent().getPackageConfigByName("patchMessage")));
            sb.append(String.format("[TINKER_ID Rom Space] %d k \n", tinker.getTinkerRomSpace()));

        } else {
            sb.append(String.format("[patch is not loaded] \n"));
            //            sb.append(String.format("[buildConfig TINKER_ID] %s \n", BuildInfo.TINKER_ID));
            //            sb.append(String.format("[buildConfig BASE_TINKER_ID] %s \n", BaseBuildInfo.BASE_TINKER_ID));

            //            sb.append(String.format("[buildConfig MESSSAGE] %s \n", BuildInfo.MESSAGE));
            sb.append(String.format("[TINKER_ID] %s \n", ShareTinkerInternals.getManifestTinkerID(getApplicationContext())));
        }
        //        sb.append(String.format("[BaseBuildInfo Message] %s \n", BaseBuildInfo.TEST_MESSAGE));

        final TextView v = new TextView(context);
        v.setText(sb);
        showMessageTv.setText(sb);

        v.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        v.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        v.setTextColor(0xFF000000);
        v.setTypeface(Typeface.MONOSPACE);
        final int padding = 16;
        v.setPadding(padding, padding, padding, padding);

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setView(v);
        //        final AlertDialog alert = builder.create();
        //        alert.show();
        return true;
    }
}
