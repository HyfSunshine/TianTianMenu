package com.tiantian.menu.baseinterface;

import com.tiantian.menu.bean.MenuBean;
import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.bean.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/12/5.
 *
 */

public interface GetResponse {
    public static final String requestUrl = "http://39.108.224.208/CookBook/";

    public static final String JDCookBookUrl = "https://way.jd.com/jisuapi/";

    @GET("GetLoginData")
    Call<User> getLoginData(@Query("username")String username, @Query("password")String password);

    @GET("GetChildByID")
    Call<MenuType> getChildByType(@Query("menuType") String menuType);

    @GET("byclass")
    Call<MenuBean> getMenuByTypeID(@QueryMap Map<String,Object> map);
}
