package com.tiantian.menu.menus.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tiantian.menu.bean.MenuType;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/12.
 * e-mail:253139409@qq.com
 */

public class MyCNAdapter extends CommonNavigatorAdapter {

    private ArrayList<MenuType.DataBean> titleBeans;
    private ViewPager vp;

    public MyCNAdapter(ViewPager vp) {
        this.vp = vp;
    }

    public void setTitleBeans(ArrayList<MenuType.DataBean> titleBeans) {
        this.titleBeans = titleBeans;
    }

    @Override
    public int getCount() {
        return titleBeans == null ? 0 : titleBeans.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {


        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
        colorTransitionPagerTitleView.setSelectedColor(Color.WHITE);
        colorTransitionPagerTitleView.setBackgroundColor(Color.RED);
        colorTransitionPagerTitleView.setText(titleBeans.get(index).getName());
        colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(index);
            }
        });
        return colorTransitionPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        return indicator;
    }
}
