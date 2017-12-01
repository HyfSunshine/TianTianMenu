package com.tiantian.menu.minterface;

import com.tiantian.menu.models.MenuBean;
import com.tiantian.menu.models.MenuType;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/11/29.
 */

public interface GetMenu_Interface {

    @GET("GetChildByID")
    Call<MenuType> getChildByType(@Query("menuType") String menuType);


    @GET("byclass")
    Call<MenuBean>getMenuByID(@QueryMap Map<String,Object> map);


}
