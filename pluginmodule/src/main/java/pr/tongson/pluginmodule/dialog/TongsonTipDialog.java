package pr.tongson.pluginmodule.dialog;

import android.content.Context;

import pr.tongson.pluginmodule.R;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/19<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> <br>
 */

public class TongsonTipDialog  extends TongsonBaseDialog{
    private Context mContext;


    public TongsonTipDialog(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView() {
        setContentView(R.layout.tongson_tip_dialog_layout);

    }
}
