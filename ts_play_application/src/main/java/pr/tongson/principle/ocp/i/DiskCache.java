package pr.tongson.principle.ocp.i;

import android.graphics.Bitmap;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> SD卡缓存DiskCache类   <br>
 */
public class DiskCache implements ImageCache {
    @Override
    public Bitmap get(String url) {
        return null/* 从本地文件中获取该图片 */;
    }

    @Override
    public void put(String url, Bitmap bmp) {
        // 将Bitmap写入文件中  
    }
}  