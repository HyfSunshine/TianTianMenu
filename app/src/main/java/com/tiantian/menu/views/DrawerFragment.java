package com.tiantian.menu.views;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiantian.menu.R;
import com.tiantian.menu.bean.MenuType;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class DrawerFragment extends Fragment {

    private Context mContext;
    private ViewPager vp;
    private ArrayList<String> mTitleDataList;

    private List<MenuType.DataBean> listData;

    public static DrawerFragment newInstance(ArrayList<MenuType.DataBean> listData) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("listData",listData);
        DrawerFragment fragment = new DrawerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        listData = getArguments().getParcelableArrayList("listData");
        View v = inflater.inflate(R.layout.fragment_menus, container, false);
        mContext = getActivity();
        initVp(v);
        return v;
    }

    private void initVp(View view) {
        mTitleDataList = new ArrayList<>();
        for(int i = 0; i< listData.size(); i++){
            listData.get(i);
            mTitleDataList.add(listData.get(i).getName());
        }
        final ArrayList<android.support.v4.app.Fragment> listFragment = new ArrayList<>();
        for (int i = 0;i< listData.size();i++){
                int classid = listData.get(i).getClassid();
            listFragment.add(ViewPagerFragment.newInstance(classid));
        }
        vp = view.findViewById(R.id.vp);
        MagicIndicator magicIndicator = view.findViewById(R.id.vp_magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(mContext);
        //commonNavigator.setAdjustMode(true);//标题是否平分屏幕宽度
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTitleDataList == null ? 0 : mTitleDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
                colorTransitionPagerTitleView.setSelectedColor(Color.WHITE);
                colorTransitionPagerTitleView.setBackgroundColor(Color.RED);
                colorTransitionPagerTitleView.setText(mTitleDataList.get(index));
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
        });

        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, vp);
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()){
            @Override
            public int getCount() {
                return listFragment.size();
            }

            @Override
            public Fragment getItem(int position) {
                return listFragment.get(position);
            }
        };
        vp.setAdapter(adapter);
    }

}
