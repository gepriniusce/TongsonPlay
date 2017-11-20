package pr.tongson.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <b>Create Date:</b> 2017/11/20<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class ImageCache {
    private static final String TAG = ImageCache.class.getSimpleName();
    private Context context;

    public ImageCache(final Context context) {
        this.context = context.getApplicationContext();
        (new Thread() {
            @Override
            public void run() {
                long externalSize = ImageCache.this.cacheDirSize(ImageCache.this.getExternalCacheDir());
                File file = context.getCacheDir();
                long cacheSize = 1L;
                if (file != null) {
                    cacheSize = ImageCache.this.cacheDirSize(file);
                }

                float size = Float.valueOf((float) externalSize).floatValue() / 1048576.0F;
                if (size > 10.0F) {
                    ImageCache.delete(ImageCache.this.getExternalCacheDir());
                }

                size = (float) (cacheSize / 1048576L);
                if (size > 6.0F) {
                    ImageCache.delete(context.getCacheDir());
                }

            }
        }).start();
    }

    private File getCacheFile() {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = this.getExternalCacheDir();
        } else {
            file = this.context.getCacheDir();
        }

        return file;
    }

    @SuppressLint({"NewApi"})
    private File getExternalCacheDir() {
        File file = null;
        file = this.context.getExternalCacheDir();

        if (file == null) {
            file = new File(Environment.getExternalStorageDirectory() + "/ImageCache");
        }

        return file;
    }

    public boolean saveImage(String path, Bitmap bitmap) {
        String fileName = path.replace("/", "_").replace(":", "&");
        File saveFile = new File(this.getCacheFile(), fileName);
        if (saveFile.exists()) {
            return true;
        } else {
            FileOutputStream fos = null;

            boolean var7;
            try {
                fos = new FileOutputStream(saveFile);
                boolean var6 = bitmap.compress(Bitmap.CompressFormat.PNG, 85, fos);
                return var6;
            } catch (FileNotFoundException var17) {
                var7 = false;
            } finally {
                if (fos != null) {
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException var16) {
                        var16.printStackTrace();
                    }
                }

            }

            return var7;
        }
    }

    @SuppressLint({"NewApi"})
    public Bitmap getCacheImage(String path) {
        String fileName = path.replace("/", "_").replace(":", "&");
        Bitmap bitmap = null;
        File cacheFile = new File(this.getCacheFile(), fileName);
        bitmap = BitmapFactory.decodeFile(cacheFile.getAbsolutePath());
        return bitmap;
    }

    public boolean isImageExist(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        } else {
            String fileName = path.replace("/", "_").replace(":", "&");
            File saveFile = new File(this.getCacheFile(), fileName);
            return saveFile.exists();
        }
    }

    private long cacheDirSize(File file) {
        if (file == null) {
            return 0L;
        } else {
            long size = 0L;
            String[] files = file.list();
            if (files == null) {
                return 0L;
            } else {
                for (int i = 0; i < files.length; ++i) {
                    size += (new File(file, files[i])).length();
                }

                return size;
            }
        }
    }

    private static synchronized void delete(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            String[] files = file.list();

            for (int i = 0; i < files.length; ++i) {
                (new File(file, files[i])).delete();
            }

        }

    }

    public void deleteExternalCacheFile() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            delete(this.getExternalCacheDir());
        }

    }

    public void deleteCacheFile() {
        File cacheFile = this.context.getCacheDir();
        delete(cacheFile);
    }
}