/*
 * Copyright (c) 2016. 广东灵机文化传播有限公司（本内容仅限于广东灵机文化传播有限公司内部传阅，禁止外泄以及用于其他的商业目的）
 */

/**
 * 
 */
package pr.tongson.SurfaceView;

import android.graphics.Bitmap;

/**
 * 类名 ShapeEntity.java</br>
 * 创建日期 May 11, 2014</br>
 * @author Gordon</br>
 * Email gaoyulong@mmclick.com</br>
 * 更新时间 May 11, 2014 11:18:02 AM</br>
 * 最后更新者 Gordon</br>
 * 
 * 说明 动画元素
 */
public abstract class ShapeEntity {

	protected int mWidth = 0;
	protected int mHeight = 0;
	protected float mRotation = 0f;
	protected float[] mScale = { 1f, 1f };
	protected float[] mTranslate = { 0, 0 };
	protected int mAlpha = 255;

	/**
	 * 获取形状的最小外接矩形的宽度
	 * @return
	 */
	public int getWidth() {
		return mWidth;
	}

	/**
	 * 获取形状的最小外接矩形的高度
	 * @return
	 */
	public int getHeight() {
		return mHeight;
	}

	/**
	 * 获取形状的透明度
	 * @return
	 */
	public int getAlpha() {
		return mAlpha;
	}

	/**
	 * 重置该动画元素
	 */
	public void reset() {
		mAlpha = 255;
		mRotation = 0f;
		mTranslate[0] = 0;
		mTranslate[1] = 0;
		mScale[0] = 1f;
		mScale[1] = 1f;
	}
	/**
	 * 
	 */
	public void remove() {
		mAlpha = 0;
		mRotation = 0f;
		mTranslate[0] = 0;
		mTranslate[1] = 0;
		mScale[0] = 0f;
		mScale[1] = 0f;
	}

	/**
	 * 获取该形状
	 * @return
	 */
	public abstract Bitmap getBitmap();

	/**
	 * 计算
	 */
	public abstract void caculate(float diff);

	/**
	 * 该动画元素是否还有效
	 * @return
	 */
	public boolean isValid() {
		return true;
	}

	/**
	 * 获取旋转角度
	 * @return
	 */
	public float getRotation() {
		return mRotation;
	}

	/**
	 * 获取缩放
	 * @return
	 */
	public float[] getScale() {
		return mScale;
	}

	/**
	 * 获取轨迹
	 * @return
	 */
	public float[] getTranslate() {
		return mTranslate;
	}
}
