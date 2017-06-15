package pr.tongson.mvp.register;

import android.support.v4.app.FragmentTransaction;

import pr.tongson.R;
import pr.tongson.mvp.base.BaseActivity;


public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterFragment.OnFragmentInteractionListener {

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void setupFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RegisterFragment fragment = RegisterFragment.newInstance();
        transaction.add(R.id.rly_content, fragment);
        transaction.commit();
    }

}
