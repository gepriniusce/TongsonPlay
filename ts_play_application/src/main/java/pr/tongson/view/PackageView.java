package pr.tongson.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * <b>Create Date:</b> 2018/5/21<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class PackageView extends FrameLayout implements View.OnClickListener {

    private float i;

    public PackageView(@NonNull Context context) {
        super(context);
        addView();
        setOnClickListener(this);
    }

    public PackageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    private void addView() {
//        TextView textView = new TextView(getContext());
//        textView.setText("666");
//        textView.setTextSize(10);

        BaseView baseView=new BaseView(getContext());
        addView(baseView);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        matrix.postScale(0.5f + i, 0.5f + i);
        canvas.concat(matrix);
    }

    @Override
    public void onClick(View v) {
        i = i + 0.1f;
        invalidate();
    }
}
