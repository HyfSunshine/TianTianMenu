package com.tiantian.menu.menus;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiantian.menu.R;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.views.ViewPagerFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class MenusFragment extends Fragment implements MenusContract.View {

    public static MenusFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type", type);
        MenusFragment fragment = new MenusFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private MenusContract.Presenter presenter;
    private ViewPager vp;
    private MagicIndicator magicIndicator;
    private MyFragmentPagerAdapter vpAdapter;
    private MCNAdapter cnAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vpAdapter = new MyFragmentPagerAdapter(getFragmentManager());
        cnAdapter = new MCNAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String type = getArguments().getString("type");

        View root = inflater.inflate(R.layout.fragment_menus, container, false);

        vp = root.findViewById(R.id.vp);
        magicIndicator = root.findViewById(R.id.vp_magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        //commonNavigator.setAdjustMode(true);//标题是否平分屏幕宽度
        commonNavigator.setAdapter(cnAdapter);
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, vp);
        vp.setAdapter(vpAdapter);
        presenter.getMenusByType(type);
        return root;
    }

    @Override
    public void setPresenter(MenusContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showData(ArrayList<String> vpTitle, MenuType type) {
        cnAdapter.setTitles(vpTitle);
        cnAdapter.notifyDataSetChanged();
        ArrayList<Fragment>fragments = new ArrayList<>();
        int len = vpTitle.size();

        for (int i = 0;i<len;i++){
            ViewPagerFragment fragment = ViewPagerFragment.newInstance(4);
            fragments.add(fragment);
        }
        vpAdapter.setFragments(fragments);
        vpAdapter.notifyDataSetChanged();
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragments;

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setFragments(ArrayList<Fragment> fragments) {
            this.fragments = fragments;
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

    }

    class MCNAdapter extends CommonNavigatorAdapter {

        ArrayList<String> titles;

        public void setTitles(ArrayList<String> titles) {
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return titles == null ? 0 : titles.size();
        }

        @Override
        public IPagerTitleView getTitleView(Context context, final int index) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
            colorTransitionPagerTitleView.setSelectedColor(Color.WHITE);
            colorTransitionPagerTitleView.setBackgroundColor(Color.RED);
            colorTransitionPagerTitleView.setText(titles.get(index));
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
}

