package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.http.HttpFinishCallbak;

public interface SearchListBean {
    interface SearchListBeanV extends BaseView {
        void showHotList(HotBean hotList);
        void showSearchList(SearchBean hotList);
        void showSearchTopicList(SearchTopicBean searchTopicBean);
        void showError(String error);
    }

    interface SearchListBeanP{
        void getHotList();
        void getSearchList(String key);
        void getSearchTopicList(String key);
    }

    interface SearchListBeanCallBak extends HttpFinishCallbak {
        void setHotList(HotBean hotList);
        void setSearchList(SearchBean hotList);
        void setSearchTopicList(SearchTopicBean searchTopicBean);
    }
}
