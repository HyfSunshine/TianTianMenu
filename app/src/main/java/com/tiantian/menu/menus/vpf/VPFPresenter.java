package com.tiantian.menu.menus.vpf;

import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuBean;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator - stick on 2017/12/14.
 * e-mail:253139409@qq.com
 */

public class VPFPresenter implements VPFContract.Presenter,M2VListener<MenuBean>{

    private VPFContract.View view;
    private VPFContract.Model model;


    public VPFPresenter(VPFContract.View view) {
        this.view = view;
        this.model = new VPFModel();
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDestory() {

    }

    @Override
    public void getMenuByTypeID(Map map) {
        this.model.getMenuByTypeID(map,this);
    }

    @Override
    public void ntfSuccess(MenuBean menuBean) {
        this.view.refreshData(menuBean);
    }

    @Override
    public void ntfSuccess(List<MenuBean> list) {

    }

    @Override
    public void ntfFailed() {

    }
}
