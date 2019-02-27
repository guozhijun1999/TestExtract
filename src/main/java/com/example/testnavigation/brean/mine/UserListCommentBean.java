package com.example.testnavigation.brean.mine;

import java.util.List;

/**
 * Created by 88888 on 2019/2/5.
 */

public class UserListCommentBean {

    private List<UserCommentListBean> userCommentList;

    public List<UserCommentListBean> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserCommentListBean> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public static class UserCommentListBean {
        /**
         * commentId : 3174f5eaeb6c40fba7d9476cb36166d2
         * commentTime : 2019-02-02
         * content : 真皮
         * objectId : 6172b8d1c28e4f85ba2f8b73cad499c2
         * objectType : 0
         * title : null
         */

        private String commentId;
        private String commentTime;
        private String content;
        private String objectId;
        private String objectType;
        private Object title;

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }
    }
}
