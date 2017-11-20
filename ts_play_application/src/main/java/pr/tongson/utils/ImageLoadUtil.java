package pr.tongson.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * <b>Create Date:</b> 2017/9/7<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b> 偷懒玩意 <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ImageLoadUtil {
    public static final String TAG = "ImageLoadUtil";
    private Context mContext;

    public ImageLoadUtil(Context context) {
        this.mContext = context;
    }

    private Bitmap loadBitmap(String imageUrl) {
        if (TextUtils.isEmpty(imageUrl)) {
            return null;
        } else {
            try {
                URL e = new URL(imageUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) e.openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();
                return bitmap;
            } catch (MalformedURLException var6) {
                var6.printStackTrace();
            } catch (IOException var7) {
                var7.printStackTrace();
            }

            return null;
        }
    }

    public interface OnDownloadLinstener {
        void showGuide();
    }

    public void loadBitmap(String imageUrl, ImageView imageView) {
        this.loadBitmap((String) imageUrl, imageView, (OnDownloadLinstener) null);
    }

    public void loadBitmap(String imageUrl, ImageView imageView, OnDownloadLinstener onDownloadLinstener) {
        this.loadBitmap(new String[]{imageUrl}, imageView, onDownloadLinstener);
    }

    public void loadBitmap(String[] imageUrl, ImageView imageView, OnDownloadLinstener onDownloadLinstener) {
        if (NetUtil.hasNetWorkStatus(this.mContext, false) && imageUrl != null && imageUrl.length > 0) {
            (new ImageLoadUtil.MyTask(this.mContext, imageView, onDownloadLinstener)).execute(imageUrl);
        }

    }

    class MyTask extends AsyncTask<String, Void, ArrayList<Bitmap>> {
        private ImageView imageView;
        private ImageCache imageCache;
        private String imageUrl;
        private OnDownloadLinstener mDownloadLinstener;

        MyTask(Context context, ImageView imageView, OnDownloadLinstener onDownloadLinstener) {
            this.imageView = imageView;
            this.imageCache = new ImageCache(context);
            this.mDownloadLinstener = onDownloadLinstener;
        }

        @Override
        protected ArrayList<Bitmap> doInBackground(String... strings) {
            ArrayList list = new ArrayList();

            for (int i = 0; i < strings.length; ++i) {
                this.imageUrl = strings[i];
                Bitmap bitmap = this.imageCache.getCacheImage(strings[i]);
                if (bitmap != null) {
                    list.add(bitmap);
                } else {
                    bitmap = ImageLoadUtil.this.loadBitmap(strings[i]);
                    if (bitmap != null) {
                        this.imageCache.saveImage(this.imageUrl, bitmap);
                        list.add(bitmap);
                    }
                }
            }

            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Bitmap> bitmapList) {
            super.onPostExecute(bitmapList);
            if (bitmapList != null && this.imageView != null && bitmapList.size() != 0) {
                this.imageView.setImageBitmap((Bitmap) bitmapList.get(0));
            }

            if (bitmapList != null && this.mDownloadLinstener != null) {
                this.mDownloadLinstener.showGuide();
            }

        }
    }
}
