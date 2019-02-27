package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.ListFollowBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface UserListFollow {
    interface ListFollowV extends BaseView {
        void showListFollowTab(ListFollowBean listFollowBean);
        void showError(String error);
    }

    interface ListFollowP{
        void getListFollowTab(String userId);
    }

    interface ListFollowCallBak extends HttpFinishCallbak {
        void setListFollowTab(ListFollowBean listFollowBean);
    }
}
