package com.tiantian.menu.menus;

import com.tiantian.menu.BaseModel;
import com.tiantian.menu.BasePresenter;
import com.tiantian.menu.BaseView;
import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuType;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public interface MenusContract {
    interface Model extends BaseModel{
        void getMenuByType(String type, M2VListener listener);
        ArrayList<String> getVPTitle(MenuType menuType);
    }
    interface View extends BaseView<Presenter>{

        void showData(ArrayList<String> vpTitle,MenuType type);

    }
    interface Presenter extends BasePresenter{
        void getMenusByType(String type);
    }
}
