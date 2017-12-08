package com.tiantian.menu.login;

import com.tiantian.menu.bean.User;
import com.tiantian.menu.baseinterface.M2VListener;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 * desc:负责View与Model的交互，根据Model提供的数据，通过listener去更新view。
 */


public class LoginPresenter implements LoginContract.Presenter,M2VListener<User> {

    private LoginContract.View loginView;
    private LoginContract.Model loginModel;

    public LoginPresenter(LoginContract.View loginView ) {
        this.loginView = loginView;
        this.loginView.setPresenter(this);
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void login(String username, String password) {
        loginView.showLoading();
        loginModel.login(username, password,this);
    }

    @Override
    public void onAttach() {

    }

    @Override

    public void onDestory() {
        loginView = null;
    }

    @Override
    public void ntfSuccess(User user) {
        loginView.hiddenLoading();
        loginView.toMainActivity();
    }

    @Override
    public void ntfSuccess(List<User> list) {

    }

    @Override
    public void ntfFailed() {
        loginView.hiddenLoading();
        loginView.showFailedError();
    }
}
