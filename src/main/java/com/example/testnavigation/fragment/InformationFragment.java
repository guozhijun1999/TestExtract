package com.example.testnavigation.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.CompileActivity;
import com.example.testnavigation.adapter.inform.HomeAdapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.greend.MyChannelDao;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.brean.greend.TopNameId;
import com.example.testnavigation.contact.IListNewsChannel;
import com.example.testnavigation.http.HttpGreendao;
import com.example.testnavigation.presenter.IListNewsChannelP;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends BaseFragment<IListNewsChannel.ListNewsChannelV, IListNewsChannelP<IListNewsChannel.ListNewsChannelV>> implements IListNewsChannel.ListNewsChannelV {


    @BindView(R.id.home_child_tap)
    TabLayout homeChildTap;
    @BindView(R.id.home_child_vp)
    ViewPager homeChildVp;
    Unbinder unbinder;
    @BindView(R.id.home_child_compile)
    ImageView homeChildCompile;
//    private ArrayList<NameId> mNameIds=new ArrayList();
    private TopNameId mNameId;
    private ArrayList<String> mChannelId=new ArrayList<>();
    private ArrayList<String> mChannelName=new ArrayList<>();
    @Override
    protected int createLayoutId() {
        return R.layout.fragment_information;
    }

    @Override
    protected void initEventAndData() {
        mZLoadingDialog.show();
        mPresenter.getLisTab("news/listNewsChannel");
    }

    @Override
    protected IListNewsChannelP<IListNewsChannel.ListNewsChannelV> createPresemter() {
        return new IListNewsChannelP<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans) {
        mZLoadingDialog.dismiss();
        List<Fragment> fragments = new ArrayList<>();
        mNameId = new TopNameId();

        for (int i = 0; i < newsChannelListBeans.size(); i++) {
            Log.e("duanxq", "initE: "+newsChannelListBeans.size());
            homeChildTap.addTab(homeChildTap.newTab().setText(newsChannelListBeans.get(i).getChannelName()));
            fragments.add(new InformChildFragment(newsChannelListBeans.get(i).getChannelId()));
            Log.e("duanxq", "initEv: "+newsChannelListBeans.get(i).getChannelName());
            mChannelName.add(newsChannelListBeans.get(i).getChannelName());
            mChannelId.add(newsChannelListBeans.get(i).getChannelId());
//            mNameId.setChannelName(newsChannelListBeans.get(i).getChannelName());
//            mNameId.setChannelId(newsChannelListBeans.get(i).getChannelId());
        }
        homeChildTap.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homeChildVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        homeChildVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeChildTap));
        homeChildVp.setAdapter(new HomeAdapter(getChildFragmentManager(), fragments));

        //只添加一次到数据库（不为空是添加）
        List<MyChannelDao> myChannelDaos = HttpGreendao.getInstance().selectChanne();
        if(myChannelDaos.size()==0) {
            for (int i = 0; i < newsChannelListBeans.size(); i++) {
                String channelId = newsChannelListBeans.get(i).getChannelId();
                String channelname = newsChannelListBeans.get(i).getChannelName();
                if (i < 12) {
                    HttpGreendao.getInstance().insertChanne(new MyChannelDao(null, channelname, channelId, true));
                } else {
                    HttpGreendao.getInstance().insertChanne(new MyChannelDao(null, channelname, channelId, false));
                }
            }

        }
    }

    @Override
    public void showError(String error) {
        mZLoadingDialog.dismiss();
    }

    @OnClick(R.id.home_child_compile)
    public void onViewClicked() {

        Intent intent = new Intent(mActivity, CompileActivity.class);
//        Log.e("duanxq", "initEv: "+mChannelName.size());
//        intent.putExtra("nameList",mChannelName);
//        intent.putExtra("Id",mChannelId);
//        intent.putExtra("name",mNameId.getChannelName());
//        intent.putExtra("id",mNameId.getChannelId());
        startActivity(intent);
    }


    public void itemclick(List<MyChannelDao> mChanneladapter) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i <mChanneladapter.size(); i++) {
            String channelName = mChanneladapter.get(i).getChannelName();
            name.add(channelName);
            String channelId = mChanneladapter.get(i).getChannelId();
            fragments.add(new InformChildFragment(channelId));
        }
        homeChildTap.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homeChildVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        homeChildVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeChildTap));
        homeChildVp.setAdapter(new HomeAdapter(getChildFragmentManager(), fragments));
    }
}
