package com.tiantian.menu.presenters;

import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.baseinterface.OnDrawerListener;
import com.tiantian.menu.models.IDrawerModel;
import com.tiantian.menu.models.IDrawerModelImpl;
import com.tiantian.menu.views.IDrawerView;

/**
 * Created by Administrator on 2017/12/5.
 */

public class DrawerPresenterImpl implements IDrawerPresenter,OnDrawerListener {

    private IDrawerView drawerView;
    private IDrawerModel drawerModel;

    public DrawerPresenterImpl(IDrawerView drawerView) {
        this.drawerView = drawerView;
        this.drawerModel = new IDrawerModelImpl();
    }

    @Override
    public void getMenuTypes(String menuType){
        drawerModel.getMenus(menuType,this);
    }

    @Override
    public void loadDataSuccess(MenuType menuType) {
        drawerView.replaceFragment(menuType);
    }

    @Override
    public void loadDataError() {

    }
}
