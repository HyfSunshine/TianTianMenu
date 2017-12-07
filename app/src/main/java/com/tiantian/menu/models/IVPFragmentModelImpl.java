package com.tiantian.menu.models;

import com.tiantian.menu.bean.MenuBean;
import com.tiantian.menu.baseinterface.GetResponse;
import com.tiantian.menu.baseinterface.OnVPFragmentListener;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/5.
 */

public class IVPFragmentModelImpl implements IVPFragmentModel {
    @Override
    public void getMenuClass(Map map, final OnVPFragmentListener listener) {

            Retrofit rf = new Retrofit.Builder().baseUrl(GetResponse.requestUrl).addConverterFactory(GsonConverterFactory.create()).build();
            GetResponse ri = rf.create(GetResponse.class);
            Call<MenuBean> call = ri.getMenuByTypeID(map);
            call.enqueue(new Callback<MenuBean>() {

                @Override
                public void onResponse(Call<MenuBean> call, Response<MenuBean> response) {
                    listener.loadDataSuccess(response.body());
                }

                @Override
                public void onFailure(Call<MenuBean> call, Throwable t) {
                    listener.loadDataError();
                }
            });
    }
}
