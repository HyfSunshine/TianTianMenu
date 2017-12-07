package com.tiantian.menu.baseinterface;

import com.tiantian.menu.bean.MenuBean;

/**
 * Created by Administrator on 2017/12/5.
 */

public interface OnVPFragmentListener {
    void loadDataSuccess(MenuBean bean);
    void loadDataError();
}
