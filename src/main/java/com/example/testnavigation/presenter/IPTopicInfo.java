package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.brean.topic.TopicDetailsBean;
import com.example.testnavigation.contact.TopicInfo;
import com.example.testnavigation.moudle.IMNewsInfo;
import com.example.testnavigation.moudle.IMTopicInfo;

public class IPTopicInfo<V extends TopicInfo.TopicInfoV> extends BasePresenter<V> implements TopicInfo.TopicInfoP ,TopicInfo.TopicInfoCallBak{
    private IMTopicInfo mIMTopicInfo=new IMTopicInfo();
    @Override
    public void getTopicInfoTab(String topicId, String userId) {
        if (mMView!=null){
            mIMTopicInfo.getTopicinfoList(topicId,userId,this);
        }
    }

    @Override
    public void getListComment(String objectId, String objectType, String cursor) {
        if (mMView!=null){
            mIMTopicInfo.getListComment(objectId,objectType,cursor,this);
        }
    }

    @Override
    public void getUserComment(String userId, String objectId, String objectType, String content) {
        if (mMView!=null){
            mIMTopicInfo.getUserComment(userId,objectId,objectType,content,this);
        }
    }

    @Override
    public void getLike(String userId, String objectId, String objectType, String type) {
        if (mMView!=null){
            mIMTopicInfo.getLike(userId,objectId,objectType,type,this);
        }
    }

    @Override
    public void getFollow(String userId, String followUid, String type) {
        if (mMView!=null){
            mIMTopicInfo.getFollow(userId,followUid,type,this);
        }
    }

    @Override
    public void getFavourite(String userId, String objectId, String objectType, String type) {
        if (mMView!=null){
            mIMTopicInfo.getFavourite(userId,objectId,objectType,type,this);
        }
    }

    @Override
    public void setTopicInfoTab(TopicDetailsBean topicDetailsBean) {
        if (mMView!=null){
            mMView.showTopicInfoTab(topicDetailsBean);
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
    public void setFollow() {
        if (mMView!=null){
            mMView.showFollow();
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
