package com.example.testnavigation.brean.topic;

import java.util.List;

/**
 * Created by 88888 on 2019/1/29.
 */

public class ListCommentBean {

    /**
     * commentList : [{"commentTime":"2019-01-18 14:48:51","content":"哦哦哦","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-18 10:51:12","content":"呵呵","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-18 07:56:27","content":"不好孬","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2019-01-08 18:41:38","content":"挺好","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"d56ea66e7ee741f498ca51242c8c6394"},{"commentTime":"2019-01-08 15:57:23","content":"么么么么","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-28/c383f4c9026d471da0184ad5b24c0365_1548649149918.png","nickname":"user51569289","userId":"c383f4c9026d471da0184ad5b24c0365"},{"commentTime":"2019-01-08 10:46:01","content":"蛋啊","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg","nickname":"傻子","userId":"049de01db14a4c8184faa0aca7facf8a"},{"commentTime":"2018-11-23 08:36:38","content":"哈哈","headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-11/cb354164117a44a2b28ff9aa0a5e48bd_1547169805890.png","nickname":"wode","userId":"cb354164117a44a2b28ff9aa0a5e48bd"},{"commentTime":"2018-11-22 15:52:16","content":"得瑟，","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"6f2280e2847845a0897226af728e3854"},{"commentTime":"2018-11-22 15:52:16","content":"得瑟，","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"6f2280e2847845a0897226af728e3854"},{"commentTime":"2018-11-22 15:52:12","content":"得瑟","headImagePath":"http://39.107.254.232/firstga/imagesnull","nickname":null,"userId":"6f2280e2847845a0897226af728e3854"}]
     * cursor : 2
     */

    private String cursor;
    private List<CommentListBean> commentList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class CommentListBean {
        /**
         * commentTime : 2019-01-18 14:48:51
         * content : 哦哦哦
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-01-28/049de01db14a4c8184faa0aca7facf8a_1548681932790.jpg
         * nickname : 傻子
         * userId : 049de01db14a4c8184faa0aca7facf8a
         */

        private String commentTime;
        private String content;
        private String headImagePath;
        private String nickname;
        private String userId;

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

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
