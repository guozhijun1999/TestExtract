package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.brean.topic.TopicDetailsBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface TopicInfo {
    interface TopicInfoV extends BaseView {
        void showTopicInfoTab(TopicDetailsBean topicDetailsBean);
        void showListCommentTab(ListCommentBean listCommentBean);
        void showUserComment();
        void showLike();
        void showFollow();
        void showFavourite();
        void showError(String error);
    }

    interface TopicInfoP{
        void getTopicInfoTab(String topicId, String userId);
        void getListComment(String objectId, String objectType, String cursor);
        void getUserComment(String userId, String objectId, String objectType, String content);
        void getLike(String userId, String objectId, String objectType, String type);
        void getFollow(String userId, String followUid, String type);
        void getFavourite(String userId, String objectId, String objectType, String type);
    }

    interface TopicInfoCallBak extends HttpFinishCallbak {
        void setTopicInfoTab(TopicDetailsBean topicDetailsBean);
        void setListCommentTab(ListCommentBean listCommentBean);
        void setUserComment();
        void setLike();
        void setFollow();
        void setFavourite();
    }
}
