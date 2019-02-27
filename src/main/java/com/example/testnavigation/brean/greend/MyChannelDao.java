package com.example.testnavigation.brean.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class MyChannelDao {
    @Id(autoincrement = true)
    Long id;
    String channelName;
    String channelId;
    boolean bo;
    @Generated(hash = 198729059)
    public MyChannelDao(Long id, String channelName, String channelId, boolean bo) {
        this.id = id;
        this.channelName = channelName;
        this.channelId = channelId;
        this.bo = bo;
    }
    @Generated(hash = 177995392)
    public MyChannelDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getChannelName() {
        return this.channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public String getChannelId() {
        return this.channelId;
    }
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    public boolean getBo() {
        return this.bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }
}
