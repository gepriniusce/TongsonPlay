package com.example.testbroast_order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class FirstRecever extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        //先获得传过来的MSG
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "FirstRecever："+msg);

        //更改广播数据
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@FirstReceiver");
        setResultExtras(bundle);
    }
}
//abortBroadcast();  //终止消息再传递