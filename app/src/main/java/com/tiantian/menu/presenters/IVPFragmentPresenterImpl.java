package com.tiantian.menu.presenters;

import com.tiantian.menu.bean.MenuBean;
import com.tiantian.menu.baseinterface.OnVPFragmentListener;
import com.tiantian.menu.models.IVPFragmentModel;
import com.tiantian.menu.models.IVPFragmentModelImpl;
import com.tiantian.menu.views.IVPFragmentView;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/5.
 */

public class IVPFragmentPresenterImpl implements IVPFragmentPresenter,OnVPFragmentListener {

    private IVPFragmentView fragmentView;
    private IVPFragmentModel fragmentModel;

    public IVPFragmentPresenterImpl(IVPFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        this.fragmentModel = new IVPFragmentModelImpl();
    }

    @Override
    public void getMenuByTypeID(Map map) {
        fragmentModel.getMenuClass(map,this);
    }

    @Override
    public void loadDataSuccess(MenuBean bean) {
        fragmentView.refreshData(bean);
    }

    @Override
    public void loadDataError() {

    }
}
