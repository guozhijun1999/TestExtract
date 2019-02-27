package com.example.testnavigation.activeity.inform;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.HotAdapter;
import com.example.testnavigation.adapter.inform.SousuoTabAdapter;
import com.example.testnavigation.adapter.inform.TopListAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.contact.SearchListBean;
import com.example.testnavigation.fragment.inform.HutiFragment;
import com.example.testnavigation.fragment.inform.WenzhangFragment;
import com.example.testnavigation.presenter.IPSearchListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SousuoActivity extends BaseActivity<SearchListBean.SearchListBeanV, IPSearchListBean<SearchListBean.SearchListBeanV>> implements SearchListBean.SearchListBeanV {

    @BindView(R.id.sousuo)
    EditText mSousuo;
    @BindView(R.id.quxiao)
    TextView mQuxiao;
    @BindView(R.id.lishi)
    TextView mLishi;
    @BindView(R.id.cler)
    TextView mCler;
    @BindView(R.id.list_top)
    ListView mListTop;
    @BindView(R.id.linear)
    RelativeLayout mLinear;
    @BindView(R.id.remen)
    TextView mRemen;
    @BindView(R.id.list_bottom)
    ListView mListBottom;
    @BindView(R.id.sousuo_tab)
    TabLayout mSousuoTab;
    @BindView(R.id.sousuo_pager)
    ViewPager mSousuoPager;
    private List<HotBean.DataBean.SearchListBean> Hotlist;
    private SharedPreferences sh;
    private SharedPreferences.Editor edit;
    public int a=-1;
    private List<String> tim = new ArrayList<>();
    private TopListAdapter topShi;
    private HotAdapter hotshi;
    List<String> title=new ArrayList<>();
    List<Fragment> list=new ArrayList<>();

    @Override
    protected void initEventAndData() {
        mPresenter.getHotList();
        Hotlist=new ArrayList<>();
        sh = getSharedPreferences("xxx", MODE_PRIVATE);
        edit = sh.edit();
        a = sh.getInt("size", 0);

        for (int i = 0; i < sh.getInt("size", 0)+1; i++) {
            tim.add(sh.getString("toplist" + i, ""));
        }

        topShi = new TopListAdapter(this, tim);
        mListTop.setAdapter(topShi);


        hotshi =new HotAdapter(this,Hotlist);
        mListBottom.setAdapter(hotshi);

        mSousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    mQuxiao.setText("取消");
                } else {
                    mQuxiao.setText("搜索");
                }
            }
        });
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
        return R.layout.activity_sousuo;
    }

    @Override
    protected IPSearchListBean<SearchListBean.SearchListBeanV> createdPresenter() {
        return new IPSearchListBean<>();
    }

    @Override
    public void showHotList(HotBean hotList) {
        Hotlist.addAll(hotList.getData().getSearchList());
        //Log.i("==================", "show: "+hotBean);
        hotshi.notifyDataSetChanged();
    }

    @Override
    public void showSearchList(SearchBean hotList) {

    }

    @Override
    public void showSearchTopicList(SearchTopicBean searchTopicBean) {

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

    @OnClick({R.id.quxiao, R.id.cler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quxiao:
                if (mQuxiao.getText().toString().equals("取消") && mRemen.getVisibility()==View.VISIBLE) {
                    finish();
                }else if(mRemen.getVisibility()==View.GONE){
                    mSousuoTab.setVisibility(View.GONE);
                    mSousuoPager.setVisibility(View.GONE);

                    mLinear.setVisibility(View.VISIBLE);
                    mRemen.setVisibility(View.VISIBLE);
                    mListBottom.setVisibility(View.VISIBLE);

                    title.clear();
                    list.clear();
                }
                if (mQuxiao.getText().toString().equals("搜索")) {

                    //persenter.getsearch(sousuo.getText().toString());

                    title.add("文章");
                    title.add("话题");
                    list.add(new WenzhangFragment(mSousuo.getText().toString()));
                    list.add(new HutiFragment(mSousuo.getText().toString()));

                    SousuoTabAdapter Tabadapter=new SousuoTabAdapter(getSupportFragmentManager(),title,list);
                    mSousuoTab.setupWithViewPager(mSousuoPager);
                    mSousuoPager.setAdapter(Tabadapter);

                    mLinear.setVisibility(View.GONE);
                    mRemen.setVisibility(View.GONE);
                    mListBottom.setVisibility(View.GONE);

                    mSousuoTab.setVisibility(View.VISIBLE);
                    mSousuoPager.setVisibility(View.VISIBLE);



                    tim.add(mSousuo.getText().toString());
                    mSousuo.setText("");
                    mQuxiao.setText("取消");
                    a++;
                    edit.putInt("size", a);
                    edit.putString("toplist" + a, tim.get(a));
                    topShi.notifyDataSetChanged();
                    edit.commit();
                }
                break;
            case R.id.cler:
                break;
        }
    }
}
