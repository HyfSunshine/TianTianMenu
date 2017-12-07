package com.tiantian.menu.baseinterface;

import com.tiantian.menu.bean.MenuType;

/**
 * Created by Administrator on 2017/12/5.
 */

public interface OnDrawerListener {
    void loadDataSuccess(MenuType menuType);
    void loadDataError();
}
