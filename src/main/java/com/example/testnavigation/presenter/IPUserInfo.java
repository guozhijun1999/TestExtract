package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.UserInfoBean;
import com.example.testnavigation.contact.UserInfo;
import com.example.testnavigation.moudle.IMUserInfo;

public class IPUserInfo<V extends UserInfo.UserInfoV> extends BasePresenter<V> implements UserInfo.UserInfoP ,UserInfo.UserInfoCallBak{
    private IMUserInfo mIMUserInfo=new IMUserInfo();
    @Override
    public void getUserInfoTab(String userId) {
        if (mMView!=null){
            mIMUserInfo.getUserInfoList(userId,this);
        }
    }

    @Override
    public void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex) {
        if (mMView!=null){
            mIMUserInfo.getUpdateInfo(userId,birthday,nickname,personalProfile,professionId,sex,this);
        }
    }

    @Override
    public void setUserInfoTab(UserInfoBean userInfoBean) {
        if (mMView!=null){
            mMView.showUserInfoTab(userInfoBean);
        }
    }

    @Override
    public void setUpdateInfo() {
        if (mMView!=null){
            mMView.showUpdateInfo();
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
