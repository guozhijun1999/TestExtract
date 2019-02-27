package com.example.testnavigation.brean.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class BottomNameId {
    @Id(autoincrement = true)
    private Long id;
    private String channelId;
    private String channelName;
    @Generated(hash = 759976511)
    public BottomNameId(Long id, String channelId, String channelName) {
        this.id = id;
        this.channelId = channelId;
        this.channelName = channelName;
    }
    @Generated(hash = 1382778126)
    public BottomNameId() {
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
