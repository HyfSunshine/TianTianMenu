package com.tiantian.menu.models;

import com.tiantian.menu.baseinterface.OnDrawerListener;

/**
 * Created by Administrator on 2017/12/5.
 */

public interface IDrawerModel {
    void getMenus(String menuType, OnDrawerListener listener);
}
