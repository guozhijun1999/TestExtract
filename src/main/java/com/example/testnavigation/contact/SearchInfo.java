package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.topic.SousuoinfoBean;
import com.example.testnavigation.http.HttpFinishCallbak;

public interface SearchInfo {
    interface SearchInfoV extends BaseView {
        void setSousuo(SousuoinfoBean sousuo);
        void showError(String error);
    }

    interface SearchInfoP{
        void getSousuo(String key);
    }

    interface SearchInfoCallBak extends HttpFinishCallbak {
        void setSousuo(SousuoinfoBean sousuo);
    }
}
