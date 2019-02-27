package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.UserInfoBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface UserInfo {
    interface UserInfoV extends BaseView {
        void showUserInfoTab(UserInfoBean userInfoBean);
        void showUpdateInfo();
        void showError(String error);
    }

    interface UserInfoP{
        void getUserInfoTab(String userId);
        void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex);
    }

    interface UserInfoCallBak extends HttpFinishCallbak {
        void setUserInfoTab(UserInfoBean userInfoBean);
        void setUpdateInfo();
    }
}
