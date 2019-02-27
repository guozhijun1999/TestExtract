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
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.mine.ListFollowadapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.mine.ListFollowBean;
import com.example.testnavigation.contact.UserListFollow;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserListFollow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttentionActivity extends BaseActivity<UserListFollow.ListFollowV, IPUserListFollow<UserListFollow.ListFollowV>> implements UserListFollow.ListFollowV {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.atttention_add)
    TextView mAtttentionAdd;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ListFollowadapter mListFollowadapter;

    @Override
    protected void initEventAndData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        mPresenter.getListFollowTab(Global.USERID);
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
        return R.layout.activity_attention;
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
    protected IPUserListFollow<UserListFollow.ListFollowV> createdPresenter() {
        return new IPUserListFollow<>();
    }

    @Override
    public void showListFollowTab(ListFollowBean listFollowBean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlv.setLayoutManager(manager);
        mListFollowadapter = new ListFollowadapter(listFollowBean.getFollowList());
        mRlv.setAdapter(mListFollowadapter);

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

    @OnClick(R.id.atttention_add)
    public void onViewClicked() {
        startActivity(new Intent(AttentionActivity.this,MoreFollowActivity.class));
    }

}
