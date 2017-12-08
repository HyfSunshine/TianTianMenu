package com.tiantian.menu.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tiantian.menu.R;
import com.tiantian.menu.utils.Commons;

/**
 * Activity负责将Presenter与View建立联系，创建View对象，创建Presenter对象，
 * */

public class LoginActivity extends AppCompatActivity {

    private LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = LoginFragment.newInstance();
        Commons.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.login_fragment_content);
        loginPresenter = new LoginPresenter(loginFragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loginPresenter!=null){
            loginPresenter.onDestory();
        }
    }
}
