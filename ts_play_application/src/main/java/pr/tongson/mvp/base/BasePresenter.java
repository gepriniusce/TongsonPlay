package pr.tongson.mvp.base;

import android.support.annotation.NonNull;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/16<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public interface BasePresenter {
    //    void onResume();

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();
}
