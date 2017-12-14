package com.tiantian.menu.menus.vpf;

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
import com.tiantian.menu.bean.MenuBean;
import com.tiantian.menu.menusdetail.MenusDetailActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/24.
 */


public class ViewPagerFragment extends Fragment implements VPFContract.View {

    private RecyclerView mRecyclerView;
    private VPFContract.Presenter presenter;
    private int classid;
    private MagicAdapter myAdapter;

    public static ViewPagerFragment newInstance(int classid) {
        System.out.println(" ViewPagerFragment newInstance ");
        Bundle args = new Bundle();
        args.putInt("classid", classid);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println(" ViewPagerFragment onAttach ");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println(" ViewPagerFragment onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println(" ViewPagerFragment onResume ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(" ViewPagerFragment onCreate ");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        System.out.println(" ViewPagerFragment onCreateView ");
        View v = inflater.inflate(R.layout.fragment_vp, container, false);
        mRecyclerView = v.findViewById(R.id.rv);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new ViewPagerFragment.MagicAdapter(R.layout.fragment_rv_item, null);
        // 设置adapter
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MenuBean.ResultBeanX.ResultBean.ListBean bean = (MenuBean.ResultBeanX.ResultBean.ListBean) adapter.getItem(position);
                goDetailAct(Integer.valueOf(bean.getId()));
            }
        });
        setNewData(classid);
        return v;
    }

    public void setNewData(int classid) {
        Map<String, Object> map = new HashMap<>();
        map.put("classid", classid);
        map.put("start", 0);
        map.put("num", 10);
        map.put("appkey", "fca7bf743bc62e427a78e6a73dcaf3bd");
        if (presenter == null) {
            presenter = new VPFPresenter(this);
        }
        presenter.getMenuByTypeID(map);
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    @Override
    public void refreshData(MenuBean menuBean) {
        List<MenuBean.ResultBeanX.ResultBean.ListBean> list = menuBean.getResult().getResult().getList();
        if (myAdapter == null)
            System.out.println("adapter is null");

        myAdapter.setNewData(list);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void goDetailAct(int id) {
        MenusDetailActivity.start(getActivity(),id);
    }

    @Override
    public void setPresenter(VPFContract.Presenter presenter) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    class MagicAdapter extends BaseQuickAdapter<MenuBean.ResultBeanX.ResultBean.ListBean, BaseViewHolder> {

        public MagicAdapter(int layoutResId, @Nullable List<MenuBean.ResultBeanX.ResultBean.ListBean> data) {
            super(layoutResId, data);
            if (data == null) {
                data = new ArrayList<>();
            }
        }

        @Override
        protected void convert(BaseViewHolder helper, MenuBean.ResultBeanX.ResultBean.ListBean item) {
            helper.setText(R.id.item_tv, item.getName());
            Glide.with(mContext).load(item.getPic()).placeholder(R.mipmap.hyf_loading).error(R.mipmap.hyf_loading_wrong).crossFade().into((ImageView) helper.getView(R.id.item_iv));
        }
    }
}
