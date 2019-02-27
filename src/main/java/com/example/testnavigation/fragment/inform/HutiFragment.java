package com.example.testnavigation.fragment.inform;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.HuaTiAdapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.contact.SearchListBean;
import com.example.testnavigation.presenter.IPSearchListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HutiFragment extends BaseFragment<SearchListBean.SearchListBeanV, IPSearchListBean<SearchListBean.SearchListBeanV>> implements SearchListBean.SearchListBeanV {

    String key;
    @BindView(R.id.topic_rv)
    XRecyclerView mTopicRv;
    Unbinder unbinder;
    private List<SearchTopicBean.DataBean.TopicListBean> mTopicBeans=new ArrayList<>();
    private HuaTiAdapter mHuaTiAdapter;

    @SuppressLint("ValidFragment")
    public HutiFragment(String key) {
        this.key = key;
    }

    public HutiFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_huti;
    }

    @Override
    protected void initEventAndData() {
        mTopicRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mHuaTiAdapter = new HuaTiAdapter(mActivity,mTopicBeans);
        mTopicRv.setAdapter(mHuaTiAdapter);

        mPresenter.getSearchTopicList(key);
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

    }

    @Override
    public void showSearchTopicList(SearchTopicBean searchTopicBean) {
        mHuaTiAdapter.addData(searchTopicBean.getData().getTopicList());
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
