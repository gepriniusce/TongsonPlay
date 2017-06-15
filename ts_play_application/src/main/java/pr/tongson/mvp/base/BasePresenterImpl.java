package pr.tongson.mvp.base;

import android.support.annotation.NonNull;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/5/16<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter {
    protected T mView;

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

}