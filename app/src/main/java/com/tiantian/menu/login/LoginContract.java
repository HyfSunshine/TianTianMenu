package com.tiantian.menu.login;

import com.tiantian.menu.BaseModel;
import com.tiantian.menu.BasePresenter;
import com.tiantian.menu.BaseView;
import com.tiantian.menu.baseinterface.M2VListener;

/**
 * Created by Administrator - stick on 2017/12/7.
 * e-mail:253139409@qq.com
 */

public interface LoginContract {

    interface Model extends BaseModel {

        void login(String username, String password, M2VListener listener);

    }

    interface View extends BaseView<Presenter> {

        String getUserName();

        String getPassword();

        void clearUserName();

        void clearPassword();

        void showLoading();

        void hiddenLoading();

        void toMainActivity();

        void showFailedError();
    }

    interface Presenter extends BasePresenter {

        void login(String username, String password);

    }

}
