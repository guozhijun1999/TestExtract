package com.example.testnavigation.brean.topic;

import java.util.List;

/**
 * Created by 88888 on 2019/1/26.
 */

public class LoadTopicBean {

    /**
     * cursor : 1547798031154698fed5f8f314fb8b33a45154583bf56
     * topicList : [{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-26/e7d9914be4214263ad8e2a3e88e72263_1548511492568.jpg","imageListThumb":null,"likes":0,"nickname":"干啥工作吧","pageviews":0,"publishTime":"2019-01-25","shareLink":"https://home.firefoxchina.cn/","title":"你回家要记得发春哦  兄得","topicId":"88d930de7ffe4fcba027fb28feccb86b","userId":"e7d9914be4214263ad8e2a3e88e72263"},{"comments":1,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-22/dc223b5fc4b74363a88caf497ece892e_1548111926574.jpg","imageListThumb":["http://39.107.254.232/firstga/images/topic/2019-01-23/dc223b5fc4b74363a88caf497ece892e_1548234443662.jpg"],"likes":0,"nickname":"9丶","pageviews":8,"publishTime":"2019-01-23","shareLink":"","title":"666","topicId":"04a24a19a9614b1cac95a71ef072ef85","userId":"dc223b5fc4b74363a88caf497ece892e"},{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg","imageListThumb":null,"likes":0,"nickname":"傻子","pageviews":6,"publishTime":"2019-01-21","shareLink":"https://home.firefoxchina.cn/","title":"明明哦","topicId":"b8ac3b38bf8c46078aeb884d9f975147","userId":"049de01db14a4c8184faa0aca7facf8a"},{"comments":1,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg","imageListThumb":null,"likes":0,"nickname":"傻子","pageviews":9,"publishTime":"2019-01-21","shareLink":"https://home.firefoxchina.cn/","title":"哈哈","topicId":"0e75c8359d0e4f97a0ac73b71a45247e","userId":"049de01db14a4c8184faa0aca7facf8a"},{"comments":2,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-26/e7d9914be4214263ad8e2a3e88e72263_1548511492568.jpg","imageListThumb":null,"likes":0,"nickname":"干啥工作吧","pageviews":7,"publishTime":"2019-01-18","shareLink":"https://home.firefoxchina.cn/","title":"你要记得发春哦  兄得","topicId":"356a46c09d4e4a37ad65c92662e8f230","userId":"e7d9914be4214263ad8e2a3e88e72263"},{"comments":1,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg","imageListThumb":null,"likes":1,"nickname":"傻子","pageviews":6,"publishTime":"2019-01-18","shareLink":"https://home.firefoxchina.cn/","title":"性感王强,在线咬人","topicId":"b1442b34dfde49599cca6ff9ebbe3c16","userId":"049de01db14a4c8184faa0aca7facf8a"},{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg","imageListThumb":null,"likes":0,"nickname":"傻子","pageviews":0,"publishTime":"2019-01-18","shareLink":"https://home.firefoxchina.cn/","title":"56485231","topicId":"616ba11ef384493ca9d2e098f3d0e8da","userId":"049de01db14a4c8184faa0aca7facf8a"},{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-26/e7d9914be4214263ad8e2a3e88e72263_1548511492568.jpg","imageListThumb":null,"likes":0,"nickname":"干啥工作吧","pageviews":3,"publishTime":"2019-01-18","shareLink":"https://home.firefoxchina.cn/","title":"321651654654","topicId":"f3d182e47c844d238fd6885331ef3d32","userId":"e7d9914be4214263ad8e2a3e88e72263"},{"comments":2,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-26/e8bbadbd51c44a139c789fb1ef062b94_1548485325569.jpg","imageListThumb":null,"likes":0,"nickname":"狗子","pageviews":10,"publishTime":"2019-01-18","shareLink":"https://www.hao123.com","title":"兔兔","topicId":"3b9c1966a6cd4777a23e38d6d85180c7","userId":"e8bbadbd51c44a139c789fb1ef062b94"},{"comments":0,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-25/049de01db14a4c8184faa0aca7facf8a_1548423321756.jpg","imageListThumb":null,"likes":0,"nickname":"傻子","pageviews":1,"publishTime":"2019-01-18","shareLink":"https://home.firefoxchina.cn/","title":"懒加载","topicId":"698fed5f8f314fb8b33a45154583bf56","userId":"049de01db14a4c8184faa0aca7facf8a"}]
     */

    private String cursor;
    private List<TopicListBean> topicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<TopicListBean> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<TopicListBean> topicList) {
        this.topicList = topicList;
    }

    public static class TopicListBean {
        /**
         * comments : 0
         * headImagePath : http://39.107.254.232/firstga/images/head/2019-01-26/e7d9914be4214263ad8e2a3e88e72263_1548511492568.jpg
         * imageListThumb : null
         * likes : 0
         * nickname : 干啥工作吧
         * pageviews : 0
         * publishTime : 2019-01-25
         * shareLink : https://home.firefoxchina.cn/
         * title : 你回家要记得发春哦  兄得
         * topicId : 88d930de7ffe4fcba027fb28feccb86b
         * userId : e7d9914be4214263ad8e2a3e88e72263
         */

        private int comments;
        private String headImagePath;
        private List<String> imageListThumb;
        private int likes;
        private String nickname;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;
        private String userId;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public List<String> getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(List<String> imageListThumb) {
            this.imageListThumb = imageListThumb;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getPageviews() {
            return pageviews;
        }

        public void setPageviews(int pageviews) {
            this.pageviews = pageviews;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getShareLink() {
            return shareLink;
        }

        public void setShareLink(String shareLink) {
            this.shareLink = shareLink;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
