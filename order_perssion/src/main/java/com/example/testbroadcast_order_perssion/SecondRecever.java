package com.example.testbroadcast_order_perssion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondRecever extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "SecondRecever："+msg);

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@SecondReceiver");
        setResultExtras(bundle);
    }

}
