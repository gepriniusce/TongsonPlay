package com.example.testbroast_order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn= (Button)findViewById(R.id.sent_btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                send();
            }
        });

    }

    public void send() {
        //    	Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        //    	intent.putExtra("msg", "Test_Brodcast_static---hello receiver.");
        //    	sendBroadcast(intent);

        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
        sendOrderedBroadcast(intent, null);  //没有添加权限
    }


}
