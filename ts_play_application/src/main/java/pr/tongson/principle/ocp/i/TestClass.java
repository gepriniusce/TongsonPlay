package pr.tongson.principle.ocp.i;

import android.graphics.Bitmap;

/**
 * <b>Create Date:</b> 2017/10/12<br>
 * <b>Author:</b> mmc_Kongming_Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class TestClass {

    public static void main(String[] args) {
        ImageLoader imageLoader = new ImageLoader();
        // 使用内存缓存  
        imageLoader.setImageCache(new MemoryCache());
        // 使用SD卡缓存  
        imageLoader.setImageCache(new DiskCache());
        // 使用双缓存  
        imageLoader.setImageCache(new DoubleCache());
        // 使用自定义的图片缓存实现  
        imageLoader.setImageCache(new ImageCache() {

            @Override
            public void put(String url, Bitmap bmp) {
                // 缓存图片  
            }

            @Override
            public Bitmap get(String url) {
                return null/*从缓存中获取图片*/;
            }
        });
    }
}
