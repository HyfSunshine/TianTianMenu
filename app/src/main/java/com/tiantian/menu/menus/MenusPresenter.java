package com.tiantian.menu.menus;

import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuType;

import java.util.List;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class MenusPresenter implements MenusContract.Presenter,M2VListener<MenuType> {

    private MenusContract.View view;
    private MenusContract.Model model;


    public MenusPresenter(MenusContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.model = new MenusModel();
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
        model.getVPTitle(menuType);
        view.showData(model.getVPTitle(menuType),menuType);
    }

    @Override
    public void ntfSuccess(List<MenuType> list) {

    }

    @Override
    public void ntfFailed() {

    }
}
