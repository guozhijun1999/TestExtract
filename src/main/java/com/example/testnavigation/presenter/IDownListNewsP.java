package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.inform.DownListNews;
import com.example.testnavigation.contact.IDownListNews;
import com.example.testnavigation.moudle.IDownListNewsM;

import java.util.List;

public class IDownListNewsP<V extends IDownListNews.DownListNewsV> extends BasePresenter<V> implements IDownListNews.DownListNewsP ,IDownListNews.DownListNewsCallBak {
    private IDownListNewsM mDownListNewsM=new IDownListNewsM();
    @Override
    public void getLisTab(String url, String channelId, String page) {
        if (mMView!=null){
            mDownListNewsM.getDownListNews(url,channelId,page,this);
        }
    }

    @Override
    public void setDownListNews(List<DownListNews.NewListBean> newListBean) {
        if (mMView!=null){
            mMView.showDownListNews(newListBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
