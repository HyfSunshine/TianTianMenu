package com.tiantian.menu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.sdr.sdrbaselibrary.util.StatusBarUtils;
import com.tiantian.menu.R;
import com.tiantian.menu.base.BaseActivity;
import com.tiantian.menu.menus.MenusActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.btn_splash)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideHeaderBar();
        StatusBarUtils.setTranslucentImageHeader(this, 0, null);
        mCountDownTimer.start();
        initListener();
    }

    private void initListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
                gotoLoginOrMainActivity();
            }
        });
    }

    private CountDownTimer mCountDownTimer = new CountDownTimer(5200, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mButton.setText("跳过(" + String.format("%02d", millisUntilFinished / 1000) + "s)");
        }

        @Override
        public void onFinish() {
            mButton.setText("跳过(" + 0 + "s)");
            gotoLoginOrMainActivity();
        }
    };

    private void gotoLoginOrMainActivity() {
        startActivity(new Intent(this, MenusActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCountDownTimer.cancel();
    }

    @Override
    protected boolean isImageHeader() {
        return true;
    }
}
