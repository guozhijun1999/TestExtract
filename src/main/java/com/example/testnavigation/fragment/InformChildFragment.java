package com.example.testnavigation.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.InformationAdapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.inform.DownListNews;
import com.example.testnavigation.contact.IDownListNews;
import com.example.testnavigation.presenter.IDownListNewsP;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformChildFragment extends BaseFragment<IDownListNews.DownListNewsV, IDownListNewsP<IDownListNews.DownListNewsV>> implements IDownListNews.DownListNewsV, XRecyclerView.LoadingListener {

    @BindView(R.id.xrv)
    XRecyclerView xrv;
    Unbinder unbinder;
    private String channelId;
    private int page = 0;
    private List<DownListNews.NewListBean> mDownListNews=new ArrayList<>();
    private InformationAdapter mInformationAdapter;
    private int position=0;
    @SuppressLint("ValidFragment")
    public InformChildFragment(String channelId) {
        this.channelId = channelId;
    }

    public InformChildFragment() {
        // Required empty public constructor
    }


    @Override
    protected IDownListNewsP<IDownListNews.DownListNewsV> createPresemter() {
        return new IDownListNewsP<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_inform_child;
    }

    @Override
    protected void initEventAndData() {
        xrv.setLayoutManager(new LinearLayoutManager(mActivity));
        xrv.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.VERTICAL));
        mInformationAdapter = new InformationAdapter(mActivity, mDownListNews);
        xrv.setAdapter(mInformationAdapter);
        xrv.setLoadingListener(this);
        mPresenter.getLisTab("news/downListNews", channelId, page + "");
    }

    @Override
    public void showDownListNews(List<DownListNews.NewListBean> newListBeans) {

        mInformationAdapter.addData(page,newListBeans);
        Log.e("guomouren",newListBeans.toString());
        xrv.loadMoreComplete();
    }

    @Override
    public void showError(String error) {

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

    @Override
    public void onRefresh() {
        page=0;
        mPresenter.getLisTab("news/downListNews", channelId, page + "");
        xrv.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        mPresenter.getLisTab("news/downListNews", channelId, page + "");
    }
}
