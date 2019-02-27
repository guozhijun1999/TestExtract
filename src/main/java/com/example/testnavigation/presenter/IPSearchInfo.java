package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.topic.SousuoinfoBean;
import com.example.testnavigation.contact.SearchInfo;
import com.example.testnavigation.moudle.IMSearchInfo;

public class IPSearchInfo<V extends SearchInfo.SearchInfoV> extends BasePresenter<V> implements SearchInfo.SearchInfoP ,SearchInfo.SearchInfoCallBak {
    private IMSearchInfo mIMSearchInfo=new IMSearchInfo();
    @Override
    public void getSousuo(String key) {
        if (mMView!=null){
            mIMSearchInfo.getSousuoinfo(key,this);
        }
    }

    @Override
    public void setSousuo(SousuoinfoBean sousuo) {
        if (mMView!=null){
            mMView.setSousuo(sousuo);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
