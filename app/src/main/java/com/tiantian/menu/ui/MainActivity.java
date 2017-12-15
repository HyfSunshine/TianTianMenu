package com.tiantian.menu.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.sdr.sdrbaselibrary.weiget.SnackTopToast;
import com.tiantian.menu.R;
import com.tiantian.menu.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.hello_world)
    Button mBtn;
    //MMP,还用快速开发框架。

    private Context mContext;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //hideHeaderBar();
        RelativeLayout rl = getHeaderbarParentView();
        android.support.v7.widget.Toolbar toolbar = rl.findViewById(R.id.hyf_dark_toolbar);
        toolbar.setTitle("这里是Title");
        toolbar.setBackgroundResource(R.color.colorpick);
        toolbar.setSubtitle("这里是子标题");
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setSubtitleTextColor(Color.BLACK);
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        setSupportActionBar(toolbar);

        setHeaderBarDrawable();

        mContext = this;
        ButterKnife.bind(this);
        mBtn.setText(R.string.app_name);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(mContext,MenusActivity.class));
                new SnackTopToast(mContext, false)
                        .setBackgroundColor(Color.parseColor("#e64340"))
                        .setTitle("这是一个小提示")
                        .setTitleColor(Color.WHITE)
                        .setIconRes(R.mipmap.ic_launcher_round)
                        .setIconColor(Color.WHITE)
                        .show();

            }
        });
    }
}
