package com.tiantian.menu.menus.vpf;

import com.tiantian.menu.base.BaseModel;
import com.tiantian.menu.base.BasePresenter;
import com.tiantian.menu.base.BaseView;
import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuBean;

import java.util.Map;

/**
 * Created by Administrator - stick on 2017/12/14.
 * e-mail:253139409@qq.com
 */

public interface VPFContract {

    interface Model extends BaseModel{
        void getMenuByTypeID(Map map, M2VListener listener);
    }
    interface View extends BaseView<Presenter>{
        void refreshData(MenuBean menuBean);
        void goDetailAct(int id);
    }
    interface Presenter extends BasePresenter{
        void getMenuByTypeID(Map map);
    }
}
