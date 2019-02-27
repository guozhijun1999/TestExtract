package com.example.testnavigation.brean.topic;

/**
 * Created by 88888 on 2019/1/30.
 */

public class UserComment {
    String userId;
    String objectId;
    String objectType;
    String content;

    public UserComment() {
        super();
    }

    public UserComment(String userId, String objectId, String objectType, String content) {
        this.userId = userId;
        this.objectId = objectId;
        this.objectType = objectType;
        this.content = content;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
