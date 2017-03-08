package pr.tongson.threah;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class MainThreadActivity extends BaseActivity {

    private TextView threadMsgTV;

    private StringBuilder mStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thread);
        threadMsgTV = (TextView) findViewById(R.id.thread_msg_tv);
        mStringBuilder = new StringBuilder();

        method1();
        method2();
        method3();
    }


    private void method1() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStringBuilder.append("这里是 method1 Ui线程，哈哈！\n");
                threadMsgTV.setText(mStringBuilder);
                isMainThread();
            }
        });
    }


    private void method2() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                mStringBuilder.append("这里是 method2 Ui线程，哈哈！\n");
                threadMsgTV.setText(mStringBuilder);
                isMainThread();
            }
        });
    }

    private void method3() {
        threadMsgTV.post(new Runnable() {
            @Override
            public void run() {
                mStringBuilder.append("这里是 method3 Ui线程，哈哈！\n");
                threadMsgTV.setText(mStringBuilder);
                isMainThread();
            }
        });
    }


}
