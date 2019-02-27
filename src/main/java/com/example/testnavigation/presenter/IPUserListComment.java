package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.UserListCommentBean;
import com.example.testnavigation.contact.UserListComment;
import com.example.testnavigation.moudle.IMUserListComment;

public class IPUserListComment<V extends UserListComment.ListCommentV> extends BasePresenter<V> implements UserListComment.ListCommentP ,UserListComment.ListCommentCallBak{
    private IMUserListComment mIMUserListComment=new IMUserListComment();
    @Override
    public void getListCommentTab(String userId) {
        if (mMView!=null){
            mIMUserListComment.getUserListComment(userId,this);
        }
    }

    @Override
    public void setListCommentTab(UserListCommentBean userListCommentBean) {
        if (mMView!=null){
            mMView.showListCommentTab(userListCommentBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
