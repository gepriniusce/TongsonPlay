package pr.tongson.threah;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class LooperActivity extends BaseActivity {

    private Handler mHandler;

    private final int MSG_HELLO = 0;

    private TextView looperMsgTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper);

        looperMsgTV = (TextView) findViewById(R.id.looper_msg_tv);

        new CustomThread().start();//新建并启动CustomThread实例
        looperMsgTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.obtainMessage(MSG_HELLO, "667").sendToTarget();//发送消息到CustomThread实例
            }
        });

        looperMsgTV.setText("Hello！" );

    }


    class CustomThread extends Thread {
        @Override
        public void run() {
            //建立消息循环的步骤
            Looper.prepare();//1、初始化Looper
            mHandler = new Handler() {//2、绑定handler到CustomThread实例的Looper对象
                public void handleMessage(Message msg) {//3、定义处理消息的方法
                    switch (msg.what) {
                        case MSG_HELLO:
                            isMainThread();
                            
//                            子线程
                            break;
                    }
                }
            };
            Looper.loop();//4、启动消息循环
        }
    }
}
