package com.example.testnavigation.fragment.inform;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.DetailsActivity;
import com.example.testnavigation.adapter.inform.WenzhangAdapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.contact.SearchListBean;
import com.example.testnavigation.presenter.IPSearchListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WenzhangFragment extends BaseFragment<SearchListBean.SearchListBeanV, IPSearchListBean<SearchListBean.SearchListBeanV>> implements SearchListBean.SearchListBeanV {


    @BindView(R.id.wenzhang_recycler)
    RecyclerView mWenzhangRecycler;
    Unbinder unbinder;
    private List<SearchBean.DataBean.NewListBean> list = new ArrayList<>();
    String key;
    private WenzhangAdapter mWenzhangAdapter;

    @SuppressLint("ValidFragment")
    public WenzhangFragment(String key) {
        // Required empty public constructor
        this.key=key;
    }

    public WenzhangFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_wenzhang;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getSearchList(key);

        mWenzhangAdapter = new WenzhangAdapter(list, context);
        mWenzhangRecycler.setAdapter(mWenzhangAdapter);
        mWenzhangRecycler.setLayoutManager(new LinearLayoutManager(context));

        mWenzhangAdapter.setOnclicklistener(new WenzhangAdapter.OnClickListener() {
            @Override
            public void onclick(int i, View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("newId",list.get(i).getNewsId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected IPSearchListBean<SearchListBean.SearchListBeanV> createPresemter() {
        return new IPSearchListBean<>();
    }

    @Override
    public void showHotList(HotBean hotList) {

    }

    @Override
    public void showSearchList(SearchBean hotList) {
        list.addAll(hotList.getData().getNewList());
        mWenzhangAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSearchTopicList(SearchTopicBean searchTopicBean) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
