package com.example.testnavigation.brean.topic;

/**
 * Created by 88888 on 2019/1/29.
 */

public class ListComment {

    String objectId;
    String objectType;
    String cursor;

    public ListComment() {
        super();
    }

    public ListComment(String objectId, String objectType, String cursor) {
        this.objectId = objectId;
        this.objectType = objectType;
        this.cursor = cursor;
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

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
