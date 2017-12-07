package com.tiantian.menu.views;

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
import com.tiantian.menu.bean.MenuBean;
import com.tiantian.menu.presenters.IVPFragmentPresenter;
import com.tiantian.menu.presenters.IVPFragmentPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/24.
 */


public class ViewPagerFragment extends Fragment implements IVPFragmentView {

    private RecyclerView mRecyclerView;

    private IVPFragmentPresenter presenter;

    private int classid;
    private MagicAdapter myAdapter;

    public static ViewPagerFragment newInstance(int classid) {
        Bundle args = new Bundle();
        args.putInt("classid",classid);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vp, container,false);
        classid = getArguments().getInt("classid");
        mRecyclerView = v.findViewById(R.id.rv);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new ViewPagerFragment.MagicAdapter(R.layout.fragment_rv_item,null);
        // 设置adapter
        mRecyclerView.setAdapter(myAdapter);
        presenter = new IVPFragmentPresenterImpl(this);
        Map<String,Object>map = new HashMap<>();
        map.put("classid",classid);
        map.put("start",0);
        map.put("num",10);
        map.put("appkey","fca7bf743bc62e427a78e6a73dcaf3bd");
        presenter.getMenuByTypeID(map);
        return v;
    }

    @Override
    public void refreshData(MenuBean menuBean) {
        List<MenuBean.ResultBeanX.ResultBean.ListBean> list = menuBean.getResult().getResult().getList();
        myAdapter.setNewData(list);
        myAdapter.notifyDataSetChanged();
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
