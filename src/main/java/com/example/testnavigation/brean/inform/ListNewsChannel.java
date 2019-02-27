package com.example.testnavigation.brean.inform;

import java.util.List;

public class ListNewsChannel {

    private List<NewsChannelListBean> newsChannelList;

    public List<NewsChannelListBean> getNewsChannelList() {
        return newsChannelList;
    }

    public void setNewsChannelList(List<NewsChannelListBean> newsChannelList) {
        this.newsChannelList = newsChannelList;
    }

    public static  class NewsChannelListBean {

        /**
         * channelId : 0
         * channelName : 资讯
         */

        private String channelId;
        private String channelName;

        public NewsChannelListBean(String channelId, String channelName) {
            this.channelId = channelId;
            this.channelName = channelName;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }
    }
}
