package com.example.testnavigation.fragment.gambit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.ReleaseActivity;
import com.example.testnavigation.adapter.topic.ChoicenessAdapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.contact.LoadTopic;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPLoadTopic;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoicenessFragment extends BaseFragment<LoadTopic.LoadTopicV, IPLoadTopic<LoadTopic.LoadTopicV>> implements LoadTopic.LoadTopicV, XRecyclerView.LoadingListener {


    @BindView(R.id.topic_relase)
    ImageView topicRelase;
    @BindView(R.id.topic_rv)
    XRecyclerView topicRv;
    Unbinder unbinder;
    private String mCursor;
    private List<LoadTopicBean.TopicListBean> mListBeans = new ArrayList<>();
    private ChoicenessAdapter mChoicenessAdapter;

    public ChoicenessFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_choiceness;
    }

    @Override
    protected void initEventAndData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        topicRv.setLayoutManager(manager);
        mChoicenessAdapter = new ChoicenessAdapter(mActivity, mListBeans);
        topicRv.setAdapter(mChoicenessAdapter);
        topicRv.setLoadingListener(this);
    }

    @Override
    public void load() {
        super.load();
        mPresenter.getLoadTopicTab("1", "0", Global.USERID, "d56ea6c8c6394");
    }

    @Override
    protected IPLoadTopic<LoadTopic.LoadTopicV> createPresemter() {
        return new IPLoadTopic<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showLoadTopicTab(LoadTopicBean loadTopicBean) {
        mCursor = loadTopicBean.getCursor();
        mChoicenessAdapter.addData(mCursor, loadTopicBean.getTopicList());
        topicRv.loadMoreComplete();
    }

    @Override
    public void showLike() {

    }

    @Override
    public void showFollow() {

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
        mPresenter.getLoadTopicTab("1", "0", Global.USERID, "d56ea6c8c6394");
        topicRv.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        mPresenter.getLoadTopicTab("1", "0", Global.USERID, "d56ea6c8c6394");

    }

    @OnClick(R.id.topic_relase)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), ReleaseActivity.class));
    }
}
