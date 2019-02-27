package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.http.HttpFinishCallbak;

import java.util.List;

public interface IListNewsChannel {
    interface ListNewsChannelV extends BaseView{
        void showListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans);

        void showError(String error);
    }

    interface ListNewsChannelP{
        void getLisTab(String json);

    }

    interface ListNewsChannelCallBak extends HttpFinishCallbak{
        void setListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans);

    }
}
