package com.example.testnavigation.brean.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class TopNameId {
    @Id(autoincrement = true)
    private Long id;
    private String channelId;
    private String channelName;
    @Generated(hash = 809942120)
    public TopNameId(Long id, String channelId, String channelName) {
        this.id = id;
        this.channelId = channelId;
        this.channelName = channelName;
    }
    @Generated(hash = 1810116964)
    public TopNameId() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChannelId() {
        return this.channelId;
    }
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public String getChannelName() {
        return this.channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
