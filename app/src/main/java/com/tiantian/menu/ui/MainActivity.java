package com.tiantian.menu.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tiantian.menu.R;
import com.tiantian.menu.base.BaseActivity;
import com.tiantian.menu.menus.MenusActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.hello_world)
    Button mBtn;
    //MMP,还用快速开发框架。

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.bind(this);
        mBtn.setText(R.string.app_name);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext,MenusActivity.class));
            }
        });
    }
}
