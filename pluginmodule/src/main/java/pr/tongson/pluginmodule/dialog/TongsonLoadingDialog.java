package pr.tongson.pluginmodule.dialog;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import pr.tongson.pluginmodule.R;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/3/18<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> 数据加载时候的Dialog <br>
 */

public class TongsonLoadingDialog extends TongsonBaseDialog {

    public TongsonLoadingDialog(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.image_loading));
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.dialog_anim_loading);
        imageView.startAnimation(animation);
        setContentView(imageView);
    }



}
