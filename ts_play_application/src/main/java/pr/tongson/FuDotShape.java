/*
 * Copyright (c) 2016. 广东灵机文化传播有限公司（本内容仅限于广东灵机文化传播有限公司内部传阅，禁止外泄以及用于其他的商业目的）
 */

/**
 * 
 */
package pr.tongson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;


/**
 * 类名 FuDotShape.java</br>
 * 创建日期 May 23, 2014</br>
 * @author Gordon</br>
 * Email gaoyulong@mmclick.com</br>
 * 更新时间 May 23, 2014 2:22:54 PM</br>
 * 最后更新者 Gordon</br>
 * 
 * 说明 飘动的点点。
 */
public class FuDotShape extends ShapeEntity {

	private static Bitmap mDotBitmap = null;
	private double mSpeed = 0;
	private float mScaleIndex = 0;
	private View mView = null;
	private boolean isReInit = true;

	public FuDotShape(double speed, float scaleIndex, View v) {
		this.mSpeed = speed;
		this.mView = v;
		this.mScaleIndex = scaleIndex;
		if (null == mDotBitmap) {
			mDotBitmap = BitmapFactory.decodeResource(v.getResources(), R.mipmap.qifu_fy_dot);
		}

		mWidth = mDotBitmap.getWidth();
		mHeight = mDotBitmap.getHeight();
		mTranslate[0] = (int) (-mWidth / 2f);
		mTranslate[1] = (int) (-mHeight / 2f);
	}

	@Override
	public void caculate(float diff) {
		if (isReInit) {
			isReInit = false;
			mTranslate[0] = (int) (mView.getWidth() * Math.random());
			mTranslate[1] = (int) (mView.getHeight() * Math.random());
			mScale[0] = (float) (mScaleIndex * Math.random() + 0.1f);
			mScale[1] = mScale[0];
			mWidth *= mScale[0];
			mHeight *= mScale[1];
		}

		mTranslate[1] -= mSpeed * diff;
		if (mTranslate[1] + getHeight() <= 0) {
			mTranslate[1] = mView.getHeight();
		}
	}

	@Override
	public Bitmap getBitmap() {
		return mDotBitmap;
	}

}
