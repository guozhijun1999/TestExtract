package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.contact.LoadTopic;
import com.example.testnavigation.moudle.IMLoadTopic;

public class IPLoadTopic<V extends LoadTopic.LoadTopicV> extends BasePresenter<V> implements LoadTopic.LoadTopicP,LoadTopic.LoadTopicCallBak {
    private IMLoadTopic mIMLoadTopic=new IMLoadTopic();

    @Override
    public void getLoadTopicTab(String type, String cursor, String userId, String tagId) {
        if (mMView!=null){
            mIMLoadTopic.getLoadTopic(type,cursor,userId,tagId,this);
        }
    }

    @Override
    public void getLike(String userId, String objectId, String objectType, String type) {
        if (mMView!=null){
            mIMLoadTopic.getLike(userId,objectId,objectType,type,this);
        }
    }

    @Override
    public void getFollow(String userId, String followUid, String type) {
        if (mMView!=null){
            mIMLoadTopic.getFollow(userId,followUid,type,this);
        }
    }

    @Override
    public void setLoadTopicTab(LoadTopicBean loadTopicBean) {
        if (mMView!=null){
            mMView.showLoadTopicTab(loadTopicBean);
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
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
