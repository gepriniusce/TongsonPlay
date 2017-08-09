package pr.tongson.SurfaceView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/7/6<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class SparkView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private Matrix mMatrix = new Matrix();
    private Paint mPaint = new Paint();
    private boolean isRun;

    private ValueAnimator mShapeAnimator = ValueAnimator.ofFloat(0, 1);
    private List<ShapeEntity> mShapeEntities = new ArrayList<>();
    
    public SparkView(Context context) {
        super(context);
        mShapeAnimator.addUpdateListener(new ShapeViewUpdateListener(mShapeEntities, mShapeAnimator, this));
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (true) {
            mShapeAnimator.setRepeatCount(ValueAnimator.INFINITE);
        }
//        if (null != listener) {
//            mShapeAnimator.addListener(listener);
//        }
        mShapeAnimator.setStartDelay(300);
        mShapeAnimator.setDuration(3000);
        mShapeAnimator.start();
        isRun = true;

        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRun = false;
    }

    @Override
    public void run() {
        while (isRun) {
            for (ShapeEntity entity : mShapeEntities) {
                mPaint.reset();
                mMatrix.reset();

                final float scale[] = entity.getScale();
                final float[] translate = entity.getTranslate();
                mMatrix.setTranslate(-entity.getWidth() / 2f, -entity.getHeight() / 2f);
                mMatrix.postRotate(entity.getRotation());
                mMatrix.postScale(scale[0], scale[1]);
                mMatrix.postTranslate(translate[0], translate[1]);
                mPaint.setAlpha(entity.getAlpha());
                this.getHolder().lockCanvas(null).drawBitmap(entity.getBitmap(), mMatrix, mPaint);
            }
        }
    }

    public static class ShapeViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        private WeakReference<ValueAnimator> mShapeAnimator;
        private WeakReference<List<ShapeEntity>> mShapeEntities;
        private WeakReference<SparkView> mShapeFlowView;
        private long mLastTime;

        public ShapeViewUpdateListener(List<ShapeEntity> shapeEntities, ValueAnimator shapeAnimator, SparkView shapeFlowView) {
            mShapeAnimator = new WeakReference<>(shapeAnimator);
            mShapeEntities = new WeakReference<>(shapeEntities);
            mShapeFlowView = new WeakReference<>(shapeFlowView);
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            SparkView shapeFlowView = mShapeFlowView.get();
            List<ShapeEntity> shapeEntityList = mShapeEntities.get();
            ValueAnimator shapeAnimator = mShapeAnimator.get();
            if (shapeFlowView == null || shapeEntityList == null || shapeAnimator == null) return;

            long now = System.currentTimeMillis();
            final float diff = (float) (now - mLastTime) / 1000f;
            mLastTime = now;
            if (diff < 1) {
                int count = 0;
                for (ShapeEntity entity : shapeEntityList) {
                    if (!entity.isValid()) {
                        count += 1;
                        continue;
                    }
                    entity.caculate(diff);
                }
                if (count != shapeEntityList.size()) {
                    shapeFlowView.invalidate();
                    //						L.d("count= " + count);
                } else {
                    shapeAnimator.cancel();
                }
            }
        }
    }
}
