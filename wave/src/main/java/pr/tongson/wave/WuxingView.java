package pr.tongson.wave;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * <b>Create Date:</b> 2017/9/14<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class WuxingView extends View {
    private boolean mInit;
    private Paint mPaint;
    private float mProgress;
    private static final int DEFAULT_ANIMATION_DURATION = 10000;
    private ObjectAnimator mAnimator;


    /**
     * 金木水火土Bitmap
     */
    private Bitmap jinBitmap;
    private Bitmap muBitmap;
    private Bitmap shuiBitmap;
    private Bitmap huoBitmap;
    private Bitmap tuBitmap;

    private Rect jinSrcRect;
    private Rect muSrcRect;
    private Rect shuiSrcRect;
    private Rect huoSrcRect;
    private Rect tuSrcRect;

    private RectF jinDesRectF;
    private RectF muDesRectF;
    private RectF shuiDesRectF;
    private RectF huoDesRectF;
    private RectF tuDesRectF;

    int mtMutu = dp2px(85);
    int mbjinshui = dp2px(23);
    int mlrJinShui = dp2px(50);
    int mlrMuTu = dp2px(7);

    public WuxingView(Context context) {
        this(context, null);
    }

    public WuxingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WuxingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mInit = false;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        mProgress = 0;
        mAnimator = ObjectAnimator.ofFloat(this, "progress", 1);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

    }

    private void initBitmap() {
        jinBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.name_icon_anim_jin);
        muBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.name_icon_anim_mu);
        shuiBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.name_icon_anim_shui);
        huoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.name_icon_anim_huo);
        tuBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.name_icon_anim_tu);
        initJin();
        initMu();
        initShui();
        initHuo();
        initTu();
    }

    private void initHuo() {
        huoSrcRect = new Rect(0, 0, huoBitmap.getWidth(), huoBitmap.getHeight());
        int left = (getWidth() - huoBitmap.getWidth()) / 2;
        int top = 0;
        int right = left + huoBitmap.getWidth();
        int bottom = top + huoBitmap.getHeight();
        huoDesRectF = new RectF(left, top, right, bottom);
    }


    private void initTu() {
        tuSrcRect = new Rect(0, 0, tuBitmap.getWidth(), tuBitmap.getHeight());
        int left = getWidth() - tuBitmap.getWidth() - mlrMuTu;
        int top = mtMutu;
        int right = left + tuBitmap.getWidth();
        int bottom = top + tuBitmap.getHeight();
        tuDesRectF = new RectF(left, top, right, bottom);
    }

    private void initJin() {
        jinSrcRect = new Rect(0, 0, jinBitmap.getWidth(), jinBitmap.getHeight());
        int left = getWidth() - jinBitmap.getWidth() - mlrJinShui;
        int top = getHeight() - jinBitmap.getHeight() - mbjinshui;
        int right = left + jinBitmap.getWidth();
        int bottom = top + jinBitmap.getHeight();
        jinDesRectF = new RectF(left, top, right, bottom);
    }

    private void initShui() {
        shuiSrcRect = new Rect(0, 0, shuiBitmap.getWidth(), shuiBitmap.getHeight());
        int left = 0 + mlrJinShui;
        int top = getWidth() - shuiBitmap.getWidth() - mbjinshui;
        int right = left + shuiBitmap.getWidth();
        int bottom = top + shuiBitmap.getHeight();
        shuiDesRectF = new RectF(left, top, right, bottom);
    }

    private void initMu() {
        muSrcRect = new Rect(0, 0, muBitmap.getWidth(), muBitmap.getHeight());
        int left = 0 + mlrMuTu;
        int top = mtMutu;
        int right = left + muBitmap.getWidth();
        int bottom = top + muBitmap.getHeight();
        muDesRectF = new RectF(left, top, right, bottom);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            doInit();
            initBitmap();
        }
    }

    private void doInit() {
        if (!mInit) {
            beginAnimation(DEFAULT_ANIMATION_DURATION);
            mInit = true;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mInit) {
            mPaint.setAntiAlias(true);//取消锯齿
            mPaint.setStyle(Paint.Style.STROKE);
            /*圆的宽度*/
            int circleWidth = 3;
            mPaint.setStrokeWidth(circleWidth);
            mPaint.setColor(getContext().getResources().getColor(R.color.name));
            int leftTop = getWidth() / 10;
            int rightBottom = getWidth() * 9 / 10;
            RectF oval = new RectF(leftTop, leftTop, rightBottom, rightBottom);
            PathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
            mPaint.setPathEffect(effects);

            canvas.drawArc(oval, -90, 360 * mProgress, false, mPaint);

            int progressInt = (int) (mProgress * 100);
            Log.i("Tongson", "Tongson onDraw mProgress:" + mProgress + ",progressInt:" + progressInt);

            if (progressInt <= 10) {
                mPaint.setAlpha(progressInt * 20);
                canvas.drawBitmap(huoBitmap, huoSrcRect, huoDesRectF, mPaint);
            } else {
                canvas.drawBitmap(huoBitmap, huoSrcRect, huoDesRectF, mPaint);
            }

            if (progressInt >= 15 && progressInt <= 25) {
                mPaint.setAlpha((progressInt - 15) * 20);
                canvas.drawBitmap(tuBitmap, tuSrcRect, tuDesRectF, mPaint);
            } else if (progressInt < 15) {
            } else {
                canvas.drawBitmap(tuBitmap, tuSrcRect, tuDesRectF, mPaint);
            }

            if (progressInt >= 35 && progressInt <= 45) {
                mPaint.setAlpha((progressInt - 35) * 20);
                canvas.drawBitmap(jinBitmap, jinSrcRect, jinDesRectF, mPaint);
            } else if (progressInt < 35) {
            } else {
                canvas.drawBitmap(jinBitmap, jinSrcRect, jinDesRectF, mPaint);
            }

            if (progressInt >= 55 && progressInt <= 65) {
                mPaint.setAlpha((progressInt - 55) * 20);
                canvas.drawBitmap(shuiBitmap, shuiSrcRect, shuiDesRectF, mPaint);
            } else if (progressInt < 55) {
            } else {
                canvas.drawBitmap(shuiBitmap, shuiSrcRect, shuiDesRectF, mPaint);
            }

            if (progressInt >= 75 && progressInt <= 85) {
                mPaint.setAlpha((progressInt - 75) * 20);
                canvas.drawBitmap(muBitmap, muSrcRect, muDesRectF, mPaint);
            } else if (progressInt < 75) {
            } else {
                canvas.drawBitmap(muBitmap, muSrcRect, muDesRectF, mPaint);
            }
        }

        //            if (jinBitmap != null && null != jinSrcRect && null != jinDesRectF) {
        //                canvas.drawBitmap(jinBitmap, jinSrcRect, jinDesRectF, mPaint);
        //            }
        //            if (muBitmap != null && null != muSrcRect && null != muDesRectF) {
        //                canvas.drawBitmap(muBitmap, muSrcRect, muDesRectF, mPaint);
        //            }
        //            if (shuiBitmap != null && null != shuiSrcRect && null != shuiDesRectF) {
        //                canvas.drawBitmap(shuiBitmap, shuiSrcRect, shuiDesRectF, mPaint);
        //            }
        //            if (huoBitmap != null && null != huoSrcRect && null != huoDesRectF) {
        //                canvas.drawBitmap(huoBitmap, huoSrcRect, huoDesRectF, mPaint);
        //            }
        //            if (tuBitmap != null && null != tuSrcRect && null != tuDesRectF) {
        //                canvas.drawBitmap(tuBitmap, tuSrcRect, tuDesRectF, mPaint);
        //            }

    }

    public void beginAnimation(int duration) {
        setProgress(0);
        mAnimator.cancel();
        mAnimator.setDuration(duration).start();
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidate();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dp2px(float dp) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5F);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dp(float px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5F);
    }
}
