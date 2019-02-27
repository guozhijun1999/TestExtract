package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.ListTopicBean;
import com.example.testnavigation.contact.UserListTopic;
import com.example.testnavigation.moudle.IMUserListTopic;

public class IPUserListTopic<V extends UserListTopic.UserListTopicV> extends BasePresenter<V> implements UserListTopic.UserListTopicP ,UserListTopic.UserListTopicCallBak{
    private IMUserListTopic mIMUserListTopic=new IMUserListTopic();
    @Override
    public void UserListTopicTab(String userId, String cursor) {
        if (mMView!=null){
            mIMUserListTopic.getUserListTopic(userId,cursor,this);
        }
    }

    @Override
    public void setUserListTopicTab(ListTopicBean listTopicBean) {
        if (mMView!=null){
            mMView.showUserListTopicTab(listTopicBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
