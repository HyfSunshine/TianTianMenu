package com.tiantian.menu.views;

import com.tiantian.menu.bean.MenuType;

/**
 * Created by Administrator on 2017/12/5.
 */

public interface IDrawerView {
    void showDrawer();
    void hiddenDrawer();
    void replaceFragment(MenuType menuType);
    void requestError();
}
