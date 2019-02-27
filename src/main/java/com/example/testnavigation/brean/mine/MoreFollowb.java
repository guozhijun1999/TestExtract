package com.example.testnavigation.brean.mine;

/**
 * Created by 88888 on 2019/2/12.
 */

public class MoreFollowb {
    String userId;
    String tagId;
    String cursor;

    public MoreFollowb() {
        super();
    }

    public MoreFollowb(String userId, String tagId, String cursor) {
        this.userId = userId;
        this.tagId = tagId;
        this.cursor = cursor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
