package com.example.testnavigation.activeity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.inform.SousuoActivity;
import com.example.testnavigation.adapter.inform.HomeAdapter;
import com.example.testnavigation.base.SimpleActivity;
import com.example.testnavigation.fragment.CircleFragment;
import com.example.testnavigation.fragment.InformationFragment;
import com.example.testnavigation.fragment.MyFragment;
import com.example.testnavigation.fragment.gambit.GambitFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends SimpleActivity {


    //    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.home_vp)
    ViewPager homeVp;
    @BindView(R.id.home_tab)
    TabLayout homeTab;
    @BindView(R.id.image_sousuo)
    ImageView mImageSousuo;
    private InformationFragment mInformationFragment;
    private GambitFragment mGambitFragment;
    private CircleFragment mCircleFragment;
    private MyFragment mMyFragment;

    @Override
    protected void viewCreated() {

    }

    @Override
    protected void initEventAndData() {
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
        List<Fragment> fragments = new ArrayList<>();
        mInformationFragment = new InformationFragment();
        mGambitFragment = new GambitFragment();
        mCircleFragment = new CircleFragment();
        mMyFragment = new MyFragment();
        fragments.add(mInformationFragment);
        fragments.add(mGambitFragment);
        fragments.add(mCircleFragment);
        fragments.add(mMyFragment);
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.selecter_information).setText("资讯"));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.selecter_gambit).setText("话题"));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.selecter_circle).setText("圈子"));
        homeTab.addTab(homeTab.newTab().setIcon(R.drawable.selecter_my).setText("我的"));
        homeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homeVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        homeVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeTab));
        homeVp.setAdapter(new HomeAdapter(getSupportFragmentManager(), fragments));
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
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_sousuo)
    public void onViewClicked() {
        Intent intent = new Intent(this, SousuoActivity.class);
        startActivity(intent);
    }
}
