package com.example.testnavigation.activeity.mine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.ReleaseActivity;
import com.example.testnavigation.adapter.mine.MyTopicAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.mine.ListTopicBean;
import com.example.testnavigation.contact.UserListTopic;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserListTopic;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTopicActivity extends BaseActivity<UserListTopic.UserListTopicV, IPUserListTopic<UserListTopic.UserListTopicV>> implements UserListTopic.UserListTopicV {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.topic_relase)
    ImageView mTopicRelase;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private MyTopicAdapter mMyTopicAdapter;

    @Override
    protected void initEventAndData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        mPresenter.UserListTopicTab(Global.USERID, "0");
    }

    @Override
    protected int createLayoutId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
//设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置系统状态栏的颜色
            window.setStatusBarColor(getResources().getColor(R.color.home_toolbar_bgcolor));
        }
        return R.layout.activity_my_topic;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected IPUserListTopic<UserListTopic.UserListTopicV> createdPresenter() {
        return new IPUserListTopic<>();
    }

    @Override
    public void showUserListTopicTab(ListTopicBean listTopicBean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlv.setLayoutManager(manager);
        mMyTopicAdapter = new MyTopicAdapter(mActivity, listTopicBean.getFavouritTopicList());
        mRlv.setAdapter(mMyTopicAdapter);
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

    @OnClick(R.id.topic_relase)
    public void onViewClicked() {
        startActivity(new Intent(mActivity, ReleaseActivity.class));
    }
}
