package com.tiantian.menu.menus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiantian.menu.R;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.menus.adapters.MyCNAdapter;
import com.tiantian.menu.menus.adapters.MyViewPagerAdapter;
import com.tiantian.menu.menus.vpf.ViewPagerFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class MenusFragment extends Fragment implements MenusContract.View {

    private MenusContract.Presenter presenter;
    private ViewPager vp;
    private MagicIndicator magicIndicator;
    private MyViewPagerAdapter vpAdapter;
    private MyCNAdapter cnAdapter;

    public static MenusFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type", type);
        MenusFragment fragment = new MenusFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menus, container, false);
        vp = root.findViewById(R.id.mf_vp);
        cnAdapter = new MyCNAdapter(vp);
        vpAdapter = new MyViewPagerAdapter(getFragmentManager());
        magicIndicator = root.findViewById(R.id.vp_magic_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        //commonNavigator.setAdjustMode(true);//标题是否平分屏幕宽度
        commonNavigator.setAdapter(cnAdapter);
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, vp);
        vp.setAdapter(vpAdapter);
        presenter.getMenusByType(getArguments().getString("type"));
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
    public void changeTitleAndVP(ArrayList<MenuType.DataBean> titleBeans, ArrayList<ViewPagerFragment> fragments) {

        cnAdapter.setTitleBeans(titleBeans);
        cnAdapter.notifyDataSetChanged();
        vpAdapter.setFragments(fragments);
        vpAdapter.notifyDataSetChanged();
        vp.setCurrentItem(0);
    }
}

