package pr.tongson.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import pr.tongson.service.MyService;

public class MyReceiver extends BroadcastReceiver {
    public static final String TAG = "MyReceiver";

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, intent.getAction());
        Log.e(TAG, "6666");
        String msg = intent.getStringExtra("msg");
        Log.e(TAG, msg);

//        intent = new Intent(context, RegisterActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
     
        intent = new Intent(context, MyService.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(intent);
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //        throw new UnsupportedOperationException("Not yet implemented");
    }
}
