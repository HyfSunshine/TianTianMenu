package com.tiantian.menu.ui;

import android.annotation.SuppressLint;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tiantian.menu.R;
import com.tiantian.menu.minterface.GetMenu_Interface;
import com.tiantian.menu.models.MenuBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/24.
 */

@SuppressLint("ValidFragment")
public class ViewPagerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private Context mContext;
    private LayoutInflater mInflate;
    private int classid;
    private MagicAdapter myAdapter;
    public ViewPagerFragment(int classid) {
        this.classid = classid;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vp, container,false);
        System.out.println("ViewPagerFragment OnreatView classid="+classid);
        mContext = getActivity();
        mInflate = inflater;
        mRecyclerView = v.findViewById(R.id.rv);
        mLayoutManager = new GridLayoutManager(mContext,3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> datas = new ArrayList<>();
        for (int i =0;i<15;i++){
            datas.add("data:"+i);
        }
        myAdapter = new ViewPagerFragment.MagicAdapter(R.layout.fragment_rv_item,null);
        // 设置adapter
        mRecyclerView.setAdapter(myAdapter);
        request();
        return v;
    }


    private void request() {//?classid=2&start=0&num=10&appkey=您申请的APPKEY"
        Retrofit rf = new Retrofit.Builder().baseUrl("https://way.jd.com/jisuapi/").addConverterFactory(GsonConverterFactory.create()).build();
        GetMenu_Interface ri = rf.create(GetMenu_Interface.class);
        Map<String,Object>map = new HashMap<>();
        map.put("classid",classid);
        map.put("start",0);
        map.put("num",10);
        map.put("appkey","fca7bf743bc62e427a78e6a73dcaf3bd");
        //对 发送请求 进行封装
        Call<MenuBean> call = ri.getMenuByID(map);
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<MenuBean>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<MenuBean> call, Response<MenuBean> response) {
                // 步骤7：处理返回的数据结果
                //response.body().show();
                MenuBean bean = response.body();
                List<MenuBean.ResultBeanX.ResultBean.ListBean> list = bean.getResult().getResult().getList();
                myAdapter.setNewData(list);
                System.out.println("VpFragment连接成功 list size="+list.size());
                myAdapter.notifyDataSetChanged();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<MenuBean> call, Throwable throwable) {
                System.out.println("连接失败"+throwable);
            }
        });

    }

    class MagicAdapter extends BaseQuickAdapter<MenuBean.ResultBeanX.ResultBean.ListBean,BaseViewHolder>{

        public MagicAdapter(int layoutResId, @Nullable List<MenuBean.ResultBeanX.ResultBean.ListBean> data) {
            super(layoutResId, data);
            if(data == null){
                data = new ArrayList<>();
            }
        }

        @Override
        protected void convert(BaseViewHolder helper, MenuBean.ResultBeanX.ResultBean.ListBean item) {
            helper.setText(R.id.item_tv,item.getName());
            Glide.with(mContext).load(item.getPic()).placeholder(R.mipmap.hyf_loading).error(R.mipmap.hyf_loading_wrong).crossFade().into((ImageView) helper.getView(R.id.item_iv));
        }
    }
}
