package com.example.testnavigation.brean.topic;

import java.util.List;

/**
 * Created by 88888 on 2019/2/1.
 */

public class TagsSearchBean {

    /**
     * tagList : [{"id":"e4ac82883b0611e8b64c00163e30445","tag":"无人机"},{"id":"07c5679841084845b07d9a2f64b290d8","tag":"无人机，直升机"},{"id":"07a00a6324bd46abbddb1331b23cb080","tag":"无人机监管"},{"id":"e4bcc5083b0611e8b64c00163e30445d","tag":"无人机应用"}]
     * cursor : 0
     */

    private String cursor;
    private List<TagListBean> tagList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TagListBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagListBean> tagList) {
        this.tagList = tagList;
    }

    public static class TagListBean {
        /**
         * id : e4ac82883b0611e8b64c00163e30445
         * tag : 无人机
         */

        private String id;
        private String tag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }
}
