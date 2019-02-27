package com.example.testnavigation.activeity.mine;

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
import com.example.testnavigation.fragment.mine.PlinformationFragment;
import com.example.testnavigation.fragment.mine.PltopicFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentActivity extends SimpleActivity {

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
        PlinformationFragment plinformationFragment = new PlinformationFragment();
        PltopicFragment pltopicFragment = new PltopicFragment();
        fragments.add(plinformationFragment);
        fragments.add(pltopicFragment);
        mTab.addTab(mTab.newTab().setText("资讯"));
        mTab.addTab(mTab.newTab().setText("话题"));
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
        mVp.setAdapter(new HomeAdapter(getSupportFragmentManager(),fragments));
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
        return R.layout.activity_comment;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
