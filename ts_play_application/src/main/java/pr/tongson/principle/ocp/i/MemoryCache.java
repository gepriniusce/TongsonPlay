package pr.tongson.principle.ocp.i;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 内存缓存MemoryCache类  <br>
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCache() {
        // 初始化LRU缓存  
    }

    @Override
    public Bitmap get(String url) {
        return mMemeryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mMemeryCache.put(url, bmp);
    }
}  