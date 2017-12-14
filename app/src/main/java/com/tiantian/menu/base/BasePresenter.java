package com.tiantian.menu.base;

/**
 * Created by Administrator on 2017/12/6.
 */


/**
 * 提取Presenter共有的方法到此接口，其它的Presenter只要继承至该接口即可。
 * */

public interface BasePresenter {

    void onAttach();
    void onDestory();
}
