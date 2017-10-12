package pr.tongson.principle.ocp.i;

import android.graphics.Bitmap;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public interface ImageCache {
    public Bitmap get(String url);

    public void put(String url, Bitmap bmp);
}
