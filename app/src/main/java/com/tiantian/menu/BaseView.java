package com.tiantian.menu;

/**
 * Created by Administrator on 2017/12/6.
 */

/**
 * 提取View共有的方法，其它View只需继承至该View即可
 * */
public interface BaseView<T> {

    void setPresenter(T presenter);

    void showLoading();
    void hiddenLoading();
}
