package com.example.testnavigation.activeity.topic;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.topic.SousuoInfoAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.topic.SousuoinfoBean;
import com.example.testnavigation.contact.SearchInfo;
import com.example.testnavigation.presenter.IPSearchInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SousuoInfoactivity extends BaseActivity<SearchInfo.SearchInfoV, IPSearchInfo<SearchInfo.SearchInfoV>> implements SearchInfo.SearchInfoV {

    @BindView(R.id.sousuoinfo_fanhui)
    ImageView mSousuoinfoFanhui;
    @BindView(R.id.sousuoinfo_title)
    TextView mSousuoinfoTitle;
    @BindView(R.id.sousuoinfo_recycler)
    RecyclerView mSousuoinfoRecycler;
    List<SousuoinfoBean.DataBean.TopicListBean> mTopicListBeans=new ArrayList<>();
    private SousuoInfoAdapter mSousuoInfoAdapter;

    @Override
    protected void initEventAndData() {
        mPresenter.getSousuo(getIntent().getStringExtra("keyword"));
        mSousuoinfoTitle.setText(getIntent().getStringExtra("keyword"));

        mSousuoinfoRecycler.setLayoutManager(new LinearLayoutManager(this));

        //Recyclerview分割线
        mSousuoinfoRecycler.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        mSousuoInfoAdapter = new SousuoInfoAdapter(mActivity,mTopicListBeans);
        mSousuoinfoRecycler.setAdapter(mSousuoInfoAdapter);
    }

    @Override
    protected int createLayoutId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
//设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置系统状态栏的颜色
            window.setStatusBarColor(getResources().getColor(R.color.home_toolbar_bgcolor));}
        return R.layout.activity_sousuo_infoactivity;
    }

    @Override
    protected IPSearchInfo<SearchInfo.SearchInfoV> createdPresenter() {
        return new IPSearchInfo<>();
    }

    @Override
    public void setSousuo(SousuoinfoBean sousuo) {
        mSousuoInfoAdapter.addData(sousuo.getData().getTopicList());
    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sousuoinfo_fanhui)
    public void onViewClicked() {
        finish();
    }
}
