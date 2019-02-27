package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface ListNotify {
    interface ListNotifyV extends BaseView {
        void showListNotifyTab(ListNotifyBean listNotifyBean);
        void showError(String error);
    }

    interface ListNotifyP{
        void getListNotifyTab(String userId);
    }

    interface ListNotifyCallBak extends HttpFinishCallbak {
        void setListNotifyTab(ListNotifyBean listNotifyBean);
    }
}
