package pr.tongson.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/6/12<br>
 * <b>Author:</b> Tongson<br>
 * <b>Description:</b> <br>
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    public T mPresenter;

    private View mFragmentView;

    public abstract T setupPresenter();

    public abstract int getLayoutId();

    public abstract void initDatas();

    public abstract void initViews(View view);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setupPresenter();
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
        initDatas();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            if (mPresenter != null) {
                mPresenter.attachView(this);
            }
            initViews(mFragmentView);
        }
        return mFragmentView;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }


}
