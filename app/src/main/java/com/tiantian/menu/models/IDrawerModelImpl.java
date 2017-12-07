package com.tiantian.menu.models;

import com.tiantian.menu.bean.MenuType;
import com.tiantian.menu.baseinterface.GetResponse;
import com.tiantian.menu.baseinterface.OnDrawerListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/5.
 */

public class IDrawerModelImpl implements IDrawerModel {
    @Override
    public void getMenus(String menuType, final OnDrawerListener listener) {

        Retrofit rf = new Retrofit.Builder().baseUrl(GetResponse.requestUrl).addConverterFactory(GsonConverterFactory.create()).build();
        GetResponse ri = rf.create(GetResponse.class);
        Call<MenuType> call = ri.getChildByType(menuType);
        call.enqueue(new Callback<MenuType>() {
            @Override
            public void onResponse(Call<MenuType> call, Response<MenuType> response) {
                listener.loadDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MenuType> call, Throwable t) {
                listener.loadDataError();
            }
        });
    }
}
