package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/19.
 */

public interface LoadTopic {
    interface LoadTopicV extends BaseView {
        void showLoadTopicTab(LoadTopicBean loadTopicBean);
        void showLike();
        void showFollow();
        void showError(String error);
    }

    interface LoadTopicP{
        void getLoadTopicTab(String type, String cursor, String userId, String tagId);
        void getLike(String userId, String objectId, String objectType, String type);
        void getFollow(String userId, String followUid, String type);
    }

    interface LoadTopicCallBak extends HttpFinishCallbak {
        void setLoadTopicTab(LoadTopicBean loadTopicBean);
        void setLike();
        void setFollow();
    }
}
