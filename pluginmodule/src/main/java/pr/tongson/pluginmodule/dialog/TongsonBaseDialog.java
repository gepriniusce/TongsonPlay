package pr.tongson.pluginmodule.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import pr.tongson.pluginmodule.R;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/18<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> Tongson's Dialog的爸爸 <br>
 */

public abstract class TongsonBaseDialog extends Dialog {

    private Context mContext;

    public TongsonBaseDialog(Context context) {
        super(context, R.style.TongsonBaseDialogStyle);
        mContext = context;
        initEnterExitAnim();
    }

    public TongsonBaseDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
        initEnterExitAnim();
    }

    /**
     * 进场动画
     */
    public void initEnterExitAnim() {
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置为居中
        dialogWindow.setWindowAnimations(R.style.dialogWindowAnim);// 添加动画效果
        int widthPixels;
        int heightPixels;
        WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        widthPixels = dm.widthPixels;
        heightPixels = dm.heightPixels;
        layoutParams.height = heightPixels;
        layoutParams.width = widthPixels;
        dialogWindow.setAttributes(layoutParams);
    }
}
