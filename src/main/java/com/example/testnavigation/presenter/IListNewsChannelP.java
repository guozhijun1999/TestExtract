package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.contact.IListNewsChannel;
import com.example.testnavigation.moudle.IListNewsChannelM;

import java.util.List;

public class IListNewsChannelP <V extends IListNewsChannel.ListNewsChannelV> extends BasePresenter<V> implements IListNewsChannel.ListNewsChannelP,IListNewsChannel.ListNewsChannelCallBak {
    private IListNewsChannelM mIListNewsChannelM=new IListNewsChannelM();

    @Override
    public void getLisTab(String json) {
        if (mMView!=null){
            mIListNewsChannelM.getListNewsChanne(json,this);
        }
    }



    @Override
    public void setListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans) {
        if (mMView!=null){
            mMView.showListTab(newsChannelListBeans);
        }
    }



    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
