package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.ListTopicBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface UserListTopic {
    interface UserListTopicV extends BaseView {
        void showUserListTopicTab(ListTopicBean listTopicBean);
        void showError(String error);
    }

    interface UserListTopicP{
        void UserListTopicTab(String userId, String cursor);
    }

    interface UserListTopicCallBak extends HttpFinishCallbak {
        void setUserListTopicTab(ListTopicBean listTopicBean);
    }
}
