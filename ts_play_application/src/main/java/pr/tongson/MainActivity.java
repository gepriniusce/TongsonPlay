package pr.tongson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import pr.tongson.view.HighLightView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnClickListener {

    private static final String TAG = "Tongson";
    /**
     * 定义手势检测
     */
    GestureDetector mGestureDetector;
    /**
     * 缩放检测
     */
    ScaleGestureDetector mScaleGestureDetector;

    Button gestureDetector;

    Button scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = findViewById(R.id.btn_GestureDetector);
        scaleGestureDetector = findViewById(R.id.btn_ScaleGestureDetector);
        gestureDetector.setOnClickListener(this);
        scaleGestureDetector.setOnClickListener(this);

        mGestureDetector = new GestureDetector(this, this);
        mScaleGestureDetector = new ScaleGestureDetector(this, this);


        initHightLight();

    }

    private void initHightLight() {
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ImageView guideView = new ImageView(this);
        guideView.setImageBitmap(bitmap);
        
        HighLightView highLight = new HighLightView(this).
                setTargetViews(new View[]{scaleGestureDetector,gestureDetector}).
                setCanTouchToDimiss(true).
                setGuideView(guideView).
                //LOCATIONTYPE. 
                setLocationType(HighLightView.LOCATIONTYPE.BOTTOM).
                //MASK_TYPE.        
                setMaskType(HighLightView.MASK_TYPE.ROUNDRECT).
                setOffsetX(0).
                setOffsetY(0).
                setListener(new HighLightView.HighLightListener() {

                    @Override
                    public void onShow(HighLightView highLightView) {
                    }

                    @Override
                    public void onDismiss(final HighLightView highLightView) {
                      
                    }
                }).show();
        
        
        
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        if (mGestureDetector != null) {
            mGestureDetector.onTouchEvent(me);
        }
        if (mScaleGestureDetector != null) {
            mScaleGestureDetector.onTouchEvent(me);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_GestureDetector:
                mGestureDetector = new GestureDetector(this, this);
                mScaleGestureDetector = null;
                break;
            case R.id.btn_ScaleGestureDetector:
                mScaleGestureDetector = new ScaleGestureDetector(this, this);
                mGestureDetector = null;
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.i(TAG, "onDown:" + e.toString());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TAG, "onShowPress:" + e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TAG, "onSingleTapUp:" + e.toString());
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(TAG, "onScroll:" + e1.toString());
        Log.i(TAG, "onScroll:" + e2.toString());
        Log.i(TAG, "onScroll:" + distanceX);
        Log.i(TAG, "onScroll:" + distanceY);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TAG, "onLongPress:" + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling:" + e1.toString());
        Log.i(TAG, "onFling:" + e2.toString());
        Log.i(TAG, "onFling:" + velocityX);
        Log.i(TAG, "onFling:" + velocityY);
        return false;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        Log.i(TAG, "onScale:" + detector.toString());
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Log.i(TAG, "onScaleBegin:" + detector.toString());
        return false;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        Log.i(TAG, "onScaleEnd:" + detector.toString());
    }

}
