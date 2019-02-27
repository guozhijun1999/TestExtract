package com.example.testnavigation.activeity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.testnavigation.R;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.contact.IListNewsChannel;
import com.example.testnavigation.presenter.IListNewsChannelP;

import java.util.List;

public class MainActivity extends BaseActivity<IListNewsChannel.ListNewsChannelV,IListNewsChannelP<IListNewsChannel.ListNewsChannelV>>implements IListNewsChannel.ListNewsChannelV{



    public Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    protected void initEventAndData() {

       mZLoadingDialog.show();

//        mPresenter.getLisTab("news/listNewsChannel");
        new Thread(){
            @Override
            public void run() {
                super.run();
                mHandler.sendEmptyMessage(1);
            }
        }.start();

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected IListNewsChannelP<IListNewsChannel.ListNewsChannelV> createdPresenter() {
        return new IListNewsChannelP<>();
    }

    @Override
    public void showListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans) {
         mZLoadingDialog.dismiss();

    }

    @Override
    public void showError(String error) {
         mZLoadingDialog.dismiss();
    }




}
