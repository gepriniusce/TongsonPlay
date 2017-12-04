package pr.tongson;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <b>Create Date:</b> 2017/12/4<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class Se extends Service {


    private String TAG = "TimeService";
    private ScheduledExecutorService mScheduledExecutorService;
    private Timer timer = null;
    private Intent timeIntent = null;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "TimeService->onCreate");
        //初始化
        this.init();
        //定时器发送广播
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //发送广播
                Log.i(TAG, "timer");
            }
        }, 1000, 1000);
        
        mScheduledExecutorService = new ScheduledThreadPoolExecutor(2);

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {

                Log.i(TAG, "ScheduledThreadPoolExecutor：timer invoked");

            }
        };

        mScheduledExecutorService.schedule(task2, 3000, TimeUnit.MILLISECONDS);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "TimeService->onBind");
        return null;
    }

    /**
     * 相关变量初始化
     */
    private void init() {
        timer = new Timer();
        timeIntent = new Intent();
    }

    @Override
    public ComponentName startService(Intent service) {
        Log.i(TAG, "TimeService->startService");
        return super.startService(service);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "TimeService->onDestroy");
    }
}
