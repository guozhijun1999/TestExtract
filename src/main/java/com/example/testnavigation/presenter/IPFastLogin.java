package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.FastLoginBean;
import com.example.testnavigation.contact.FastLogin;
import com.example.testnavigation.moudle.IMFastLogin;

public class IPFastLogin<V extends FastLogin.FastLoginV> extends BasePresenter<V> implements FastLogin.FastLoginP ,FastLogin.FastLoginCallBak{
    private IMFastLogin mFastLogin = new IMFastLogin();
    @Override
    public void getFastLoginTab(String userId, String platform, String appVersion) {
        if (mMView!=null){
            mFastLogin.getFastLogin(userId,platform,appVersion,this);
        }
    }

    @Override
    public void setFastLoginTab(FastLoginBean fastLoginBean) {
        if (mMView!=null){
            mMView.showFastLoginTab(fastLoginBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
