package com.example.testbroast_order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	private static final String TAG = "MyReceiver";  
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		String msg = getResultExtras(true).getString("msg");  
        Log.i(TAG, "MyReceiver: " + msg);  
	}
}
