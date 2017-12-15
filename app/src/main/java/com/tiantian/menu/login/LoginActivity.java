package com.tiantian.menu.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;

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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = LoginFragment.newInstance();
        Commons.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.login_fragment_content);
        loginPresenter = new LoginPresenter(loginFragment);



        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("这里是Title");
        toolbar.setBackgroundResource(R.color.colorpick);
        toolbar.setSubtitle("这里是子标题");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setSubtitleTextColor(Color.BLACK);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loginPresenter!=null){
            loginPresenter.onDestory();
        }
    }
}
