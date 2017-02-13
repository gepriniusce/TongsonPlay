package com.example.test_brodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SecondRecever extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "SecondRecever：" + msg);
        Toast.makeText(context, "SecondRecever：" + msg, Toast.LENGTH_SHORT).show();


    }
}
