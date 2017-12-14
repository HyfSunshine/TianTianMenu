package com.tiantian.menu.menus.vpf;

import com.tiantian.menu.baseinterface.GetResponse;
import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator - stick on 2017/12/14.
 * e-mail:253139409@qq.com
 */

public class VPFModel implements VPFContract.Model {
    @Override
    public void getMenuByTypeID(Map map, final M2VListener listener) {
        Retrofit rf = new Retrofit.Builder().baseUrl(GetResponse.JDCookBookUrl).addConverterFactory(GsonConverterFactory.create()).build();
        GetResponse ri = rf.create(GetResponse.class);
        Call<MenuBean> call = ri.getMenuByTypeID(map);
        call.enqueue(new Callback<MenuBean>() {

            @Override
            public void onResponse(Call<MenuBean> call, Response<MenuBean> response) {
                listener.ntfSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MenuBean> call, Throwable t) {
                listener.ntfFailed();
            }
        });
    }
}
