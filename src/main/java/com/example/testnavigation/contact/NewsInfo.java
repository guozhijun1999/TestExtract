package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.inform.InfoBean;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface NewsInfo {
    interface NewsInfoV extends BaseView {
        void showNewsInfoTab(InfoBean info);
        void showListCommentTab(ListCommentBean listCommentBean);
        void showUserComment();
        void showLike();
        void showFavourite();
        void showError(String error);
    }

    interface NewsInfoP{
        void getNewsInfoTab(String newsId);
        void getListComment(String objectId, String objectType, String cursor);
        void getUserComment(String userId, String objectId, String objectType, String content);
        void getLike(String userId, String objectId, String objectType, String type);
        void getFavourite(String userId, String objectId, String objectType, String type);
    }

    interface NewsInfoCallBak extends HttpFinishCallbak {
        void setNewsInfoTab(InfoBean info);
        void setListCommentTab(ListCommentBean listCommentBean);
        void setUserComment();
        void setLike();
        void setFavourite();
    }
}
