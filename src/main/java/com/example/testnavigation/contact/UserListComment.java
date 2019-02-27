package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.UserListCommentBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface UserListComment {
    interface ListCommentV extends BaseView {
        void showListCommentTab(UserListCommentBean userListCommentBean);
        void showError(String error);
    }

    interface ListCommentP{
        void getListCommentTab(String userId);
    }

    interface ListCommentCallBak extends HttpFinishCallbak {
        void setListCommentTab(UserListCommentBean userListCommentBean);
    }
}
