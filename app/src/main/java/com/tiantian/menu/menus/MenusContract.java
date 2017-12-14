package com.tiantian.menu.menus;

import com.tiantian.menu.base.BaseModel;
import com.tiantian.menu.base.BasePresenter;
import com.tiantian.menu.base.BaseView;
import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.menus.vpf.ViewPagerFragment;

import java.util.ArrayList;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public interface MenusContract {
    interface Model extends BaseModel{
        void getMenuByType(String type, M2VListener listener);

    }
    interface View extends BaseView<Presenter>{

        void changeTitleAndVP(ArrayList<MenuType.DataBean> titleBeans,
                 ArrayList<ViewPagerFragment> fragments);

    }
    interface Presenter extends BasePresenter{
        void getMenusByType(String type);
    }
}
