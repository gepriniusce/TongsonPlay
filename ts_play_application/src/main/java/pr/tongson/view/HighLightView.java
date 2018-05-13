package pr.tongson.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * Created by 子信 on 2016/12/20.
 */

public class HighLightView extends ViewGroup {

    private static final String TAG = "Tongson";
    private int round = 20;
    private int offsetX = 0;
    private int offsetY = 0;
    private int maskAlpha = 0xcc;
    private int maskColor = 0xcc000000;
    private int statusBarHeight;
    //    private int actionBarHeight = 0;
    private int auchorViewId;
    private int[] parentLocation = new int[2];
    private MASK_TYPE maskType = MASK_TYPE.RECT;
    private LOCATIONTYPE locationType = LOCATIONTYPE.TOP;
    private ViewGroup auchorView;
    private View[] targetViews;
    //    private View targetView;
    private View guideView;
    private Activity mActivity;
    private boolean canTouchToDimiss = true;
    private HighLightListener mListener;

    public HighLightView(Context context) {
        super(context);
        init(context);
    }

    public HighLightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    protected void init(Context context) {
        this.mActivity = (Activity) context;
        setWillNotDraw(false);
        //        calBarHeight();
        //        calActionBarHeight();
    }

    protected void calParentHeight() {
        View view = (View) getParent();
        view.getLocationInWindow(parentLocation);
        Log.i(TAG, "老豆位于屏幕：top" + parentLocation[1] + " left:" + parentLocation[0]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (canTouchToDimiss && event.getAction() == KeyEvent.ACTION_UP) {
            this.dismiss();
            return true;
        }
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View view = getChildAt(0);
        view.measure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.AT_MOST));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        calBarHeight();
        calParentHeight();
        View view = getChildAt(0);

        int miniPos = getMiniLocationPos();

        int top = 0, bottom = 0, left = 0, right = 0, wTemp = 0, hTemp = 0;
        int width = targetViews[miniPos].getMeasuredWidth();
        int height = targetViews[miniPos].getMeasuredHeight();
        int location[] = new int[2];
        targetViews[miniPos].getLocationInWindow(location);
        Log.d(TAG, "onLayout--location:" + location[0] + ":" + location[1]);
        top = location[1] - parentLocation[1];
        left = location[0] - parentLocation[0];

        /*处理目标View的高亮形式*/
        switch (maskType) {
            case ROUNDRECT:
                wTemp = round / 4;
                hTemp = round / 4;
                break;
            case CIRCLE:
                if (width > height) {
                    wTemp = (int) Math.sqrt(width * width + height * height) - width;
                    hTemp = (width - height) / 2 + wTemp;
                } else {
                    hTemp = (int) Math.sqrt(width * width + height * height) - height;
                    wTemp = (height - width) / 2 + hTemp;
                }
                break;
            case ELLIPSE:
                double ca = (Math.sqrt(2) / 2 * width) * 2;
                double cb = (Math.sqrt(2) / 2 * height) * 2;
                wTemp = (int) ((ca - width) / 2);
                hTemp = (int) ((cb - height) / 2);
                break;
            case RECT:

                break;
        }

        /*处理位置*/
        switch (locationType) {
            case TOP:
                top -= view.getMeasuredHeight() + hTemp;
                break;
            case BOTTOM:
                top += targetViews[miniPos].getMeasuredHeight() + hTemp;
                break;
            case LEFT:
                left -= view.getMeasuredWidth() + wTemp;
                break;
            case RIGHT:
                left += targetViews[miniPos].getMeasuredWidth() + wTemp;
                break;
            case TOP_LEFT:
                left -= view.getMeasuredWidth() + wTemp;
                top -= view.getMeasuredHeight() + hTemp;
                break;
            case TOP_RIGHT:
                left += targetViews[miniPos].getMeasuredWidth() + wTemp;
                top -= view.getMeasuredHeight() + hTemp;
                break;
            case BOTTOM_LEFT:
                left -= view.getMeasuredWidth() + wTemp;
                top += targetViews[miniPos].getMeasuredHeight() + hTemp;
                break;
            case BOTTOM_RIGHT:
                left += targetViews[miniPos].getMeasuredWidth() + wTemp;
                top += targetViews[miniPos].getMeasuredHeight() + hTemp;
                break;
        }

        /*处理偏移*/
        top += offsetY;
        left += offsetX;

        /*view layout*/
        Log.i(TAG, "onLayout--" + "left:" + left + "   top:" + top + " right:" + (left + view.getMeasuredWidth()) + "    bottom:" + (top + view.getMeasuredHeight()));
        //        System.out.println("left:" + left + "   top:" + top + " right:" + (left + view.getMeasuredWidth()) + "    bottom:" + (top + view.getMeasuredHeight()));
        view.layout(left, top, left + view.getMeasuredWidth(), top + view.getMeasuredHeight());
    }

    /*
     * 计算状态栏高度
     * */
    protected void calBarHeight() {
        Rect frame = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        statusBarHeight = frame.top;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            statusBarHeight = 44;
        }
    }

    /*
     * 计算ActionBar高度
     * */
    //    private void calActionBarHeight() {
    //        ActionBar actionBar = mActivity.getActionBar();
    //        if (actionBar != null) {
    //            actionBarHeight = actionBar.getHeight();
    //        }
    //    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int rc = canvas.saveLayer(0, 0, HighLightView.this.getRight(), HighLightView.this.getBottom(), null, Canvas.ALL_SAVE_FLAG);

        if (auchorView == null) {
            auchorView = (ViewGroup) mActivity.findViewById(android.R.id.content);
        }

        Paint bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        bgPaint.setColor(maskColor);
        bgPaint.setAlpha(maskAlpha);
        /*绘制蒙板层*/
        drawDark(canvas,bgPaint);

        Paint qgPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        qgPaint.setColor(Color.WHITE);
        qgPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        /*绘制高亮地方*/
        for (View targetView : targetViews) {
            drawLight(canvas, qgPaint, targetView);
        }

        canvas.restoreToCount(rc);
    }

    private void drawDark(Canvas canvas, Paint bgPaint) {
        int auchorLeft = 0;
        int auchorTop = 0;
        int auchorWidth = auchorView.getWidth();
        int auchorHeight = auchorView.getHeight();
        canvas.drawRect(auchorLeft, auchorTop, auchorLeft + auchorWidth, auchorTop + auchorHeight, bgPaint);
        Log.i(TAG, "onDraw--蒙板层：left：" + auchorLeft + " right：" + (auchorLeft + auchorWidth) + " top：" + auchorTop + " bottom：" + (auchorTop + auchorHeight));
        //        System.out.println("蒙板层：left：" + auchorLeft + " right：" + (auchorLeft + auchorWidth) + " top：" + auchorTop + " bottom：" + (auchorTop + auchorHeight));
    }

    private void drawLight(Canvas canvas, Paint qgPaint, View targetView) {
        int[] highlightLocation = new int[2];
        targetView.getLocationInWindow(highlightLocation);
        int width = targetView.getWidth();
        int height = targetView.getHeight();
        int left = highlightLocation[0] - parentLocation[0];
        int right = left + width;
        int top = highlightLocation[1] - parentLocation[1];
        int bottom = top + height;
        Log.i(TAG, "onDraw--高亮层：left：" + left + " right：" + right + " top：" + top + " bottom：" + bottom);
        /*算高亮形式*/
        switch (maskType) {
            case RECT:
                canvas.drawRect(left, top, right, bottom, qgPaint);
                break;
            case ROUNDRECT:
                RectF targetRectF = new RectF(left - round / 4, top - round / 4, right + round / 4, bottom + round / 4);
                canvas.drawRoundRect(targetRectF, round, round, qgPaint);
                break;
            case CIRCLE:
                /* 用view的斜边来做圆的直径，确保高亮圆圈包括所有view边界 */
                canvas.drawCircle((left + right) / 2, (top + bottom) / 2, (float) Math.sqrt(width * width + height * height) / 2, qgPaint);
                break;
            case ELLIPSE:
                double a = (Math.sqrt(2) / 2 * width) * 2;
                double b = (Math.sqrt(2) / 2 * height) * 2;
                int wTemp = (int) ((a - right + left) / 2);
                int hTemp = (int) ((b - bottom + top) / 2);
                RectF targetRectF1 = new RectF(left - wTemp, top - hTemp, right + wTemp, bottom + hTemp);
                canvas.drawOval(targetRectF1, qgPaint);
                break;
        }
    }

    /**
     * 显示高亮
     *
     * @return {@link HighLightView}自身
     */
    public HighLightView show() {
        final ViewGroup root = (ViewGroup) mActivity.findViewById(android.R.id.content);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        root.addView(this, lp);
        if (mListener != null) {
            mListener.onShow(this);
        }
        return this;
    }

    /**
     * 对auchor处理，现在先不管auchor，先全局高亮
     */
    private void dealAuchor() {
        if (auchorView instanceof FrameLayout) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) auchorView).addView(guideView, ((ViewGroup) auchorView).getChildCount(), lp);

        } else {
            FrameLayout frameLayout = new FrameLayout(mActivity);
            ViewGroup parent = (ViewGroup) auchorView.getParent();
            parent.removeView(auchorView);
            parent.addView(frameLayout, auchorView.getLayoutParams());
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            frameLayout.addView(auchorView, lp);
            frameLayout.addView(guideView);
        }
    }

    /**
     * 隐藏高亮
     *
     * @return {@link HighLightView}自身
     */
    public HighLightView dismiss() {
        ((ViewGroup) mActivity.findViewById(android.R.id.content)).removeView(HighLightView.this);
        if (mListener != null) {
            mListener.onDismiss(this);
        }
        return this;
    }

    /**
     * 获取高亮类型，例如椭圆、圆形、矩形、圆角矩形
     *
     * @return {@link MASK_TYPE} 高亮类型
     */
    public MASK_TYPE getMaskType() {
        return maskType;
    }

    /**
     * 设置高亮类型
     *
     * @param maskType {@link MASK_TYPE}其中一种
     * @return {@link HighLightView}自身
     */
    public HighLightView setMaskType(MASK_TYPE maskType) {
        this.maskType = maskType;
        return this;
    }

    /**
     * 获取引导view的位置，例如上、下、左、右、左上等
     *
     * @return {@link LOCATIONTYPE} 引导view的位置
     */
    public LOCATIONTYPE getLocationType() {
        return locationType;
    }

    public HighLightView setLocationType(LOCATIONTYPE locationType) {
        this.locationType = locationType;
        return this;
    }

    /**
     * 获取引导view在x方向的偏移
     *
     * @return offsetX x方向的偏移
     */
    public int getOffsetX() {
        return px2dp(mActivity, offsetX);
    }

    /**
     * 设置引导view在x方向的偏移
     *
     * @param offsetX x方向的偏移
     * @return {@link HighLightView}自身
     */
    public HighLightView setOffsetX(int offsetX) {
        this.offsetX = dp2px(mActivity, offsetX);
        return this;
    }

    /**
     * 获取引导view在y方向的偏移
     *
     * @return offsetY y方向的偏移
     */
    public int getOffsetY() {
        return px2dp(mActivity, offsetY);
    }

    /**
     * 设置引导view在y方向的偏移
     *
     * @param offsetY y方向的偏移
     * @return {@link HighLightView}自身
     */
    public HighLightView setOffsetY(int offsetY) {
        this.offsetY = dp2px(mActivity, offsetY);
        return this;
    }

    /**
     * 获取蒙板层的颜色
     *
     * @return maskColor 蒙板层的颜色
     */
    public int getMaskColor() {
        return maskColor;
    }

    /**
     * 设置蒙板层的颜色
     *
     * @param maskColor 16进制颜色，如0xcc123456
     * @return {@link HighLightView}自身
     */
    public HighLightView setMaskColor(int maskColor) {
        this.maskColor = maskColor;
        return this;
    }

    /**
     * 暂不支持设置局部高亮，请不要调用该方法
     *
     * @return 钩子view
     */
    public ViewGroup getAuchorView() {
        return auchorView;
    }

    /**
     * 暂不支持设置局部高亮，请不要调用该方法
     *
     * @param auchorView 钩子view
     * @return {@link HighLightView}自身
     */
    public HighLightView setAuchorView(ViewGroup auchorView) {
        this.auchorView = auchorView;
        return this;
    }

    /**
     * 暂不支持设置局部高亮，请不要调用该方法
     *
     * @return 钩子view资源ID
     */
    public int getAuchorViewId() {
        return auchorViewId;
    }

    /**
     * 暂不支持设置局部高亮，请不要调用该方法
     *
     * @param auchorViewId 钩子view资源ID
     * @return {@link HighLightView}自身
     */
    public HighLightView setAuchorViewId(int auchorViewId) {
        this.auchorViewId = auchorViewId;
        return this;
    }

    //    /**
    //     * 获取目标高亮View
    //     *
    //     * @return targetView 目标高亮View
    //     */
    //    public View getTargetView() {
    //        return targetView;
    //    }
    //
    //    /**
    //     * 设置目标高亮View
    //     *
    //     * @param targetView 目标高亮View
    //     * @return {@link HighLightView}自身
    //     */
    //    public HighLightView setTargetView(View targetView) {
    //        this.targetView = targetView;
    //        return this;
    //    }

    //    /**
    //     * 设置目标高亮View资源ID
    //     *
    //     * @param targetViewId 设置目标高亮View资源ID
    //     * @return {@link HighLightView}自身
    //     */
    //    public HighLightView setTargetViewId(int targetViewId) {
    //        this.targetView = mActivity.findViewById(targetViewId);
    //        return this;
    //    }

    public View[] getTargetViews() {
        return targetViews;
    }

    public HighLightView setTargetViews(View[] targetViews) {
        this.targetViews = targetViews;
        return this;
    }

    /**
     * 设置目标高亮View资源ID
     *
     * @param targetViewIds 设置目标高亮View资源ID
     * @return {@link HighLightView}自身
     */
    public HighLightView setTargetViewId(int[] targetViewIds) {
        this.targetViews = new View[targetViewIds.length];
        for (int i = 0; i < targetViewIds.length; i++) {
            this.targetViews[i] = mActivity.findViewById(targetViewIds[i]);
        }
        return this;
    }


    /**
     * 设置引导View
     *
     * @param guideView 引导View
     * @return {@link HighLightView}自身
     */
    public HighLightView setGuideView(View guideView) {
        this.guideView = guideView;
        this.removeAllViews();
        this.addView(guideView);
        return this;
    }

    /**
     * 获取引导View
     *
     * @return 引导View
     */
    public View getGuideView() {
        return this.guideView;
    }

    /**
     * 获取是否能够点击外部隐藏高亮
     *
     * @return 是否能够点击外部隐藏高亮
     */
    public boolean isCanTouchToDimiss() {
        return canTouchToDimiss;
    }

    /**
     * 设置是否能够点击外部隐藏高亮
     *
     * @param canTouchToDimiss 是否能够点击外部隐藏高亮
     * @return {@link HighLightView}自身
     */
    public HighLightView setCanTouchToDimiss(boolean canTouchToDimiss) {
        this.canTouchToDimiss = canTouchToDimiss;
        return this;
    }

    /**
     * 设置监听器
     *
     * @param listener 监听器
     * @return {@link HighLightView}自身
     */
    public HighLightView setListener(HighLightListener listener) {
        mListener = listener;
        return this;
    }

    /**
     * 设置蒙板层透明度
     *
     * @param alpha 蒙板层透明度
     * @return {@link HighLightView}自身
     */
    public HighLightView setMaskAlpha(int alpha) {
        if (alpha < 0) {
            alpha = 0;
        } else if (alpha > 255) {
            alpha = 255;
        }
        maskAlpha = alpha;
        return this;
    }

    /**
     * 获取蒙板层透明度
     *
     * @return 蒙板层透明度
     */
    public int getMaskAlpha() {
        return this.maskAlpha;
    }

    /**
     * 获取圆角大小（设置高亮类型为圆角矩形的时候）
     *
     * @return 圆角大小
     */
    public int getRound() {
        return round;
    }

    /**
     * 设置圆角大小（设置高亮类型为圆角矩形的时候）
     *
     * @param round 圆角大小
     * @return {@link HighLightView}自身
     */
    public HighLightView setRound(int round) {
        this.round = round;
        return this;
    }

    public int getMiniLocationPos() {
        int x[] = new int[targetViews.length];

        for (int i = 0; i < targetViews.length; i++) {
            int location[] = new int[2];
            targetViews[i].getLocationInWindow(location);
            x[i] = location[0];
        }

        int min = x[0];
        int index = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 高亮类型枚举
     */
    public enum MASK_TYPE {
        CIRCLE,//圆形
        RECT,//矩形
        ELLIPSE,//椭圆
        ROUNDRECT//圆角矩形
    }

    /**
     * 位置类型枚举
     */
    public enum LOCATIONTYPE {
        TOP,//上方
        BOTTOM,//下方
        LEFT,//左方
        RIGHT,//右方
        TOP_LEFT,//左上
        TOP_RIGHT,//右上
        BOTTOM_LEFT,//左下
        BOTTOM_RIGHT//右下
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5F);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5F);
    }


    public interface HighLightListener {
        void onShow(HighLightView highLightView);

        void onDismiss(HighLightView highLightView);
    }
}
