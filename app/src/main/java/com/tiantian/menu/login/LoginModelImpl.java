package com.tiantian.menu.login;


import com.tiantian.menu.bean.User;
import com.tiantian.menu.baseinterface.GetResponse;
import com.tiantian.menu.baseinterface.M2VListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/5.
 * desc:负责提供数据
 */

public class LoginModelImpl implements LoginContanct.Model {

    @Override
    public void login(String username, String password, final M2VListener listener) {
        Retrofit rf = new Retrofit.Builder().baseUrl(GetResponse.requestUrl).addConverterFactory(GsonConverterFactory.create()).build();
        GetResponse ri = rf.create(GetResponse.class);
        Call<User> call = ri.getLoginData(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null)
                    if (user.getCode() == 200) {
                        listener.ntfSuccess(user);
                    } else {
                        listener.ntfFailed();
                    }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.ntfFailed();
            }
        });
    }
}
