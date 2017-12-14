package com.tiantian.menu.menus.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tiantian.menu.menus.vpf.ViewPagerFragment;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/12.
 * e-mail:253139409@qq.com
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<ViewPagerFragment> fragments;

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(ArrayList<ViewPagerFragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

}
