package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.FastLoginBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/19.
 */

public interface FastLogin {
    interface FastLoginV extends BaseView {
        void showFastLoginTab(FastLoginBean fastLoginBean);
        void showError(String error);
    }

    interface FastLoginP{
        void getFastLoginTab(String userId, String platform, String appVersion);
    }

    interface FastLoginCallBak extends HttpFinishCallbak {
        void setFastLoginTab(FastLoginBean fastLoginBean);
    }
}
