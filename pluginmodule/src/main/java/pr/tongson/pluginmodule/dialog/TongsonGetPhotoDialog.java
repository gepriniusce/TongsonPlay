package pr.tongson.pluginmodule.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import pr.tongson.pluginmodule.R;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/19<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 拍照、从相册中选择、取消 <br>
 */

public class TongsonGetPhotoDialog extends TongsonBaseDialog {
    private Context mContext;
    private Button goCameraBtn;
    private Button goAlbumBtn;
    private Button cancelBtn;

    public TongsonGetPhotoDialog(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView() {
        setContentView(R.layout.tongson_get_photo_dialog_layout);
        goCameraBtn = (Button) findViewById(R.id.btn_go_camera);
        goAlbumBtn = (Button) findViewById(R.id.btn_go_album);
        cancelBtn = (Button) findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        int widthPixels;
        WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        widthPixels = display.getWidth() * 4 / 5; // 设置dialog宽度为屏幕的4/5
        layoutParams.width = widthPixels;
        dialogWindow.setAttributes(layoutParams);
    }

    public void setOnGoCameraBtnListener(View.OnClickListener listener) {
        goCameraBtn.setOnClickListener(listener);
    }

    public void setOnGoAlbumBtnBtnListener(View.OnClickListener listener) {
        goAlbumBtn.setOnClickListener(listener);
    }

    public Button getGoCameraBtn() {
        return goCameraBtn;
    }

    public Button getGoAlbumBtn() {
        return goAlbumBtn;
    }

    public Button getCancelBtn() {
        return cancelBtn;
    }
}
