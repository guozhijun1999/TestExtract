package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.contact.ListNotify;
import com.example.testnavigation.moudle.IMUserListNofity;

public class IPUserListNofity<V extends ListNotify.ListNotifyV> extends BasePresenter<V> implements ListNotify.ListNotifyP ,ListNotify.ListNotifyCallBak{
    private IMUserListNofity mIMUserListNofit=new IMUserListNofity();
    @Override
    public void getListNotifyTab(String userId) {
        if (mMView!=null){
            mIMUserListNofit.getUserListNofity(userId,this);
        }
    }

    @Override
    public void setListNotifyTab(ListNotifyBean listNotifyBean) {
        if (mMView!=null){
            mMView.showListNotifyTab(listNotifyBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
