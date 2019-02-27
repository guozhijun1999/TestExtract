package com.example.testnavigation.brean.topic;

/**
 * Created by 88888 on 2019/2/1.
 */

public class TagsSearch {
    String keyword;
    String cursor;

    public TagsSearch() {
        super();
    }

    public TagsSearch(String keyword, String cursor) {
        this.keyword = keyword;
        this.cursor = cursor;
    }

    public String getKeyword() {

        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }
}
