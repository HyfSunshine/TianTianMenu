package com.tiantian.menu.login;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tiantian.menu.R;

public class LoginActivity extends AppCompatActivity {

    private LoginContanct.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = LoginFragment.newInstance();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content,loginFragment);
        ft.commit();
        loginPresenter = new LoginPresenter(loginFragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestory();
    }
}
