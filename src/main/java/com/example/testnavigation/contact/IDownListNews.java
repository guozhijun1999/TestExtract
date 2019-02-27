package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.inform.DownListNews;
import com.example.testnavigation.http.HttpFinishCallbak;

import java.util.List;

public interface IDownListNews {
    interface DownListNewsV extends BaseView {
        void showDownListNews(List<DownListNews.NewListBean> newListBean);
        void showError(String error);
    }

    interface DownListNewsP{
        void getLisTab(String url,String channelId,String page);

    }

    interface DownListNewsCallBak extends HttpFinishCallbak {
        void setDownListNews(List<DownListNews.NewListBean> newListBean);

    }
}
