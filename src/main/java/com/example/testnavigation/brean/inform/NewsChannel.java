package com.example.testnavigation.brean.inform;

public class NewsChannel {
    public String channelId;
    public String channelName;

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

    public NewsChannel(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }
}
