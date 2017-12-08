package com.tiantian.menu.base;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.tiantian.menu.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/20.
 */

public class BaseActivity extends com.sdr.sdrbaselibrary.base.BaseActivity {
    @Override
    public void setContentView(int layoutResID) {
        setContentView(getLayoutInflater().inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    protected boolean isImageHeader() {
        return false;
    }

    @Override
    protected Drawable setHeaderBarDrawable() {
        return new ColorDrawable(getResources().getColor(R.color.colorPrimary));
    }


}
