package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.contact.SearchListBean;
import com.example.testnavigation.moudle.IMSearchListBean;
import com.example.testnavigation.moudle.IMTagsHot;

import org.greenrobot.greendao.annotation.Id;

public class IPSearchListBean<V extends SearchListBean.SearchListBeanV> extends BasePresenter<V> implements SearchListBean.SearchListBeanP ,SearchListBean.SearchListBeanCallBak{
    private IMSearchListBean mIMSearchListBean=new IMSearchListBean();
    @Override
    public void getHotList() {
        if (mMView!=null){
            mIMSearchListBean.getHot(this);
        }
    }

    @Override
    public void getSearchList(String key) {
        if (mMView!=null){
            mIMSearchListBean.getseach(this,key);
        }
    }

    @Override
    public void getSearchTopicList(String key) {
        if (mMView!=null){
            mIMSearchListBean.getSearchTopicList(this,key);
        }
    }


    @Override
    public void setHotList(HotBean hotList) {
        if (mMView!=null){
            mMView.showHotList(hotList);
        }
    }

    @Override
    public void setSearchList(SearchBean hotList) {
        if (mMView!=null){
            mMView.showSearchList(hotList);
        }
    }

    @Override
    public void setSearchTopicList(SearchTopicBean searchTopicBean) {
        if (mMView!=null){
            mMView.showSearchTopicList(searchTopicBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
