package pr.tongson;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * <b>Create Date:</b> 2017/12/4<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class No {
    private Context mContext;

    public No(Context context) {
        mContext = context;
    }

    /**
     * Notification构造器
     */
    private NotificationCompat.Builder mBuilder;
    /**
     * Notification管理
     */
    private NotificationManager mNotificationManager;

    /**
     * Notification的ID
     */
    private int notifyId = 100;

    /**
     * 初始化要用到的系统服务
     */
    public void initService() {
        mNotificationManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
    }


    /**
     * 初始化通知栏
     */
    public void initNotify() {
        mBuilder = new NotificationCompat.Builder(mContext);
        RemoteViews remoteViews = new RemoteViews("oms.mmc.fortunetelling.measuringtools.naming", R.layout.notify_tiandengyou_layout);
        remoteViews.setTextViewText(R.id.push_message_text, "领取您的优惠券！哈哈！");
        remoteViews.setImageViewResource(R.id.notify_icon_iv, R.drawable.ic_launcher);
        mBuilder.setContent(remoteViews)
                //通知产生的时间，会在通知信息里显示
                .setWhen(System.currentTimeMillis())
                //设置该通知优先级
                .setPriority(Notification.PRIORITY_DEFAULT)
                //ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setOngoing(false)
                //向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：
                .setDefaults(Notification.DEFAULT_VIBRATE)
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.drawable.ic_launcher);
    }

    /**
     * 显示通知栏点击跳转到指定Activity
     */
    public void showIntentActivityNotify() {
        // Notification.FLAG_ONGOING_EVENT --设置常驻 Flag;Notification.FLAG_AUTO_CANCEL 通知栏上点击此通知后自动清除此通知
        //		notification.flags = Notification.FLAG_AUTO_CANCEL; //在通知栏上点击此通知后自动清除此通知
        //点击后让通知将消失
        mBuilder.setAutoCancel(true);
        //点击的意图ACTION是跳转到Intent
        Intent resultIntent = new Intent();
        resultIntent.setClassName(mContext, "com.mmc.name.main.ui.activity.NameMainActivity");
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        mNotificationManager.notify(notifyId, mBuilder.build());

    }
}
