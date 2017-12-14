package com.tiantian.menu.menus;

import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.menus.vpf.ViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class MenusPresenter implements MenusContract.Presenter,M2VListener<MenuType> {

    private MenusContract.View view;
    private MenusContract.Model model;
    private ArrayList<MenuType.DataBean> titleBeans;
    private ArrayList<ViewPagerFragment> fragments;


    public MenusPresenter(MenusContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.model = new MenusModel();
        this.titleBeans = new ArrayList<>();
        this.fragments = new ArrayList<>();
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDestory() {
        view = null;
    }

    @Override
    public void getMenusByType(String type) {
        model.getMenuByType(type,this);
    }

    @Override
    public void ntfSuccess(MenuType menuType) {
        titleBeans = menuType.getData();
        int lenT = titleBeans.size();
        int lenF = fragments.size();
        System.out.println("lenf ="+lenF+",lent="+lenT);
        if(lenF<lenT){
            int len = lenT-lenF;
            for (int i = 0; i < len; i++) {
                fragments.add(ViewPagerFragment.newInstance(titleBeans.get(i).getClassid()));
            }
        }else if(lenF>lenT){
            int len = lenF - lenT;
            for (int i = 0; i < len; i++) {
                fragments.remove(fragments.size()-1);
            }
        }
        for (int i = 0; i < lenT; i++) {
            int currClassid = titleBeans.get(i).getClassid();
            ViewPagerFragment fragment = fragments.get(i);
            fragment.setClassid(currClassid);
            //每次切换大标题后，刷新VP的前两页数据，因为VP自动加载当前页和前一页后一页。
            if(i==0||i==1){
                fragment.setNewData(currClassid);
            }
        }
        view.changeTitleAndVP(titleBeans,fragments);
    }

    @Override
    public void ntfSuccess(List<MenuType> list) {

    }

    @Override
    public void ntfFailed() {

    }
}
