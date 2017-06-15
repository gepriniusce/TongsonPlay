package pr.tongson.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/6/12<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> <br>
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    public Activity mActivity;
    protected T mPresenter;

    public abstract int getLayoutId();

    public abstract void initDatas();

    public abstract void setupFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
        setContentView(getLayoutId());
        initDatas();
        setupFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }


}