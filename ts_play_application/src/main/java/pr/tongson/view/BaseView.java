package pr.tongson.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import pr.tongson.R;

/**
 * <b>Create Date:</b> 2018/5/21<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author tongs
 */
public class BaseView extends View implements View.OnClickListener {
    private float i;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

//                canvas.drawBitmap(bitmap, 0, 0, null);

        Matrix matrix = new Matrix();
        matrix.postScale(0.5f + i, 0.5f + i);
        canvas.concat(matrix);

        canvas.drawBitmap(bitmap, matrix, null);
    }

    @Override
    public void onClick(View v) {
        i++;
        invalidate();
    }
}
