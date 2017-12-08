package com.tiantian.menu.menus;

import com.tiantian.menu.baseinterface.GetResponse;
import com.tiantian.menu.baseinterface.M2VListener;
import com.tiantian.menu.bean.MenuType;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator - stick on 2017/12/8.
 * e-mail:253139409@qq.com
 */

public class MenusModel implements MenusContract.Model {

    private List<MenuType.DataBean> vpData;

    @Override
    public void getMenuByType(String type, final M2VListener listener) {
        Retrofit rf = new Retrofit.Builder().baseUrl(GetResponse.requestUrl).addConverterFactory(GsonConverterFactory.create()).build();
        GetResponse ri = rf.create(GetResponse.class);
        Call<MenuType> call = ri.getChildByType(type);
        call.enqueue(new Callback<MenuType>(){
            @Override
            public void onResponse(Call<MenuType> call, Response<MenuType> response) {
                listener.ntfSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MenuType> call, Throwable t) {
                listener.ntfFailed();
            }
        });

    }

    @Override
    public ArrayList<String> getVPTitle(MenuType menuType) {
        List<MenuType.DataBean> vpData = menuType.getData();
        ArrayList<String> vpTitle = new ArrayList<>();
        int len = vpData.size();
        for(int i = 0; i< len; i++){
            vpData.get(i);
            vpTitle.add(vpData.get(i).getName());
        }
        return vpTitle;
    }

}
