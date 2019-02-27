package com.example.testnavigation.brean.topic;

/**
 * Created by 88888 on 2019/1/27.
 */

public class Topic {
    String type;
    String cursor;
    String userId;
    String tagId;

    public Topic() {
        super();
    }

    public Topic(String type, String cursor, String userId, String tagId) {
        this.type = type;
        this.cursor = cursor;
        this.userId = userId;
        this.tagId = tagId;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
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
}
