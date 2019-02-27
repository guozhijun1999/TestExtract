package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.ListFollowBean;
import com.example.testnavigation.contact.UserListFollow;
import com.example.testnavigation.moudle.IMUserListFollow;

public class IPUserListFollow<V extends UserListFollow.ListFollowV> extends BasePresenter<V> implements UserListFollow.ListFollowP ,UserListFollow.ListFollowCallBak{
    private IMUserListFollow mIMUserListFollow=new IMUserListFollow();
    @Override
    public void getListFollowTab(String userId) {
        if (mMView!=null){
            mIMUserListFollow.getUserListFollow(userId,this);
        }
    }

    @Override
    public void setListFollowTab(ListFollowBean listFollowBean) {
        if (mMView!=null){
            mMView.showListFollowTab(listFollowBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
