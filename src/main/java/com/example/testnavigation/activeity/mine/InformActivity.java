package com.example.testnavigation.activeity.mine;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.HomeAdapter;
import com.example.testnavigation.base.SimpleActivity;
import com.example.testnavigation.fragment.mine.AttentionFragment;
import com.example.testnavigation.fragment.mine.CommentFragment;
import com.example.testnavigation.fragment.mine.InformFragment;
import com.example.testnavigation.fragment.mine.LikeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InformActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    @Override
    protected void viewCreated() {

    }

    @Override
    protected void initEventAndData() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Fragment> fragments = new ArrayList<>();
        InformFragment informFragment = new InformFragment();
        CommentFragment commentFragment = new CommentFragment();
        LikeFragment likeFragment = new LikeFragment();
        AttentionFragment attentionFragment = new AttentionFragment();
        fragments.add(informFragment);
        fragments.add(commentFragment);
        fragments.add(attentionFragment);
        fragments.add(likeFragment);

        mTab.addTab(mTab.newTab().setText("通知"));
        mTab.addTab(mTab.newTab().setText("评论我"));
        mTab.addTab(mTab.newTab().setText("关注我"));
        mTab.addTab(mTab.newTab().setText("点赞我"));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager(),fragments);
        mVp.setAdapter(homeAdapter);
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
        return R.layout.activity_inform;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
