package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.inform.InfoBean;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.contact.NewsInfo;
import com.example.testnavigation.moudle.IMNewsInfo;

public class IPNewsInfo<V extends NewsInfo.NewsInfoV> extends BasePresenter<V> implements NewsInfo.NewsInfoP,NewsInfo.NewsInfoCallBak{
    private IMNewsInfo mIMNewsInfo=new IMNewsInfo();
    @Override
    public void getNewsInfoTab(String newsId) {
        if (mMView!=null){
            mIMNewsInfo.getDownList(newsId,this);
        }
    }

    @Override
    public void getListComment(String objectId, String objectType, String cursor) {
        if (mMView!=null){
            mIMNewsInfo.getListComment(objectId,objectType,cursor,this);
        }
    }

    @Override
    public void getUserComment(String userId, String objectId, String objectType, String content) {
        if (mMView!=null){
            mIMNewsInfo.getUserComment(userId,objectId,objectType,content,this);
        }
    }

    @Override
    public void getLike(String userId, String objectId, String objectType, String type) {
        if (mMView!=null){
            mIMNewsInfo.getLike(userId,objectId,objectType,type,this);
        }
    }

    @Override
    public void getFavourite(String userId, String objectId, String objectType, String type) {
        if (mMView!=null){
            mIMNewsInfo.getFavourite(userId,objectId,objectType,type,this);
        }
    }

    @Override
    public void setNewsInfoTab(InfoBean info) {
        if (mMView!=null){
            mMView.showNewsInfoTab(info);
        }
    }

    @Override
    public void setListCommentTab(ListCommentBean listCommentBean) {
        if (mMView!=null){
            mMView.showListCommentTab(listCommentBean);
        }
    }

    @Override
    public void setUserComment() {
        if (mMView!=null){
            mMView.showUserComment();
        }
    }

    @Override
    public void setLike() {
        if (mMView!=null){
            mMView.showLike();
        }
    }

    @Override
    public void setFavourite() {
        if (mMView!=null){
            mMView.showFavourite();
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
