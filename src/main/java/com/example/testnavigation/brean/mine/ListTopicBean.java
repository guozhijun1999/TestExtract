package com.example.testnavigation.brean.mine;

import java.util.List;

/**
 * Created by 88888 on 2019/2/15.
 */

public class ListTopicBean {
    /**
     * cursor : 1549956597322a69abb62e4a9454ebfe6235ee77ffd66
     * favouritTopicList : [{"comments":1,"imageListThumb":null,"likes":1,"pageviews":9,"publishTime":"2019-02-14","shareLink":"http://www.baidu.com","title":"恐惧魔王","topicId":"c36d3c6cc3a84d9493b62e5cc2949418"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":3,"publishTime":"2019-02-14","shareLink":"http://www.baidu.com","title":"哈哈","topicId":"9af1da6aff444b2b9f4e1d3e3163a06a"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":2,"publishTime":"2019-02-14","shareLink":"http://www.baidu.com","title":"哈哈","topicId":"4a21088f8ff84e6d8b104fcfc1d6cf8c"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":22,"publishTime":"2019-02-13","shareLink":"http://www.baidu.com","title":"和交付甲方根据合肥国际化","topicId":"3b02585d2f0d41ff936cd82c92be26ee"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":9,"publishTime":"2019-02-13","shareLink":"http://www.baidu.com","title":"156561","topicId":"782ea182b7b8415f9f47fa80a71c0f57"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":6,"publishTime":"2019-02-13","shareLink":"http://www.baidu.com","title":"嘿哈","topicId":"61236fcc439c4aeaaef38eb9573ea47e"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":19,"publishTime":"2019-02-13","shareLink":"http://www.baidu.com","title":"111","topicId":"23239bc630694c9db8b990a47d1b675d"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":3,"publishTime":"2019-02-13","shareLink":"http://www.baidu.com","title":"111111","topicId":"629beb6ff5524107b39300acb3ca0ac8"},{"comments":1,"imageListThumb":null,"likes":0,"pageviews":19,"publishTime":"2019-02-12","shareLink":"https://home.firefoxchina.cn/","title":"122","topicId":"88d8fd876c69464badc1477114d0595a"},{"comments":0,"imageListThumb":null,"likes":0,"pageviews":22,"publishTime":"2019-02-12","shareLink":"http://www.baidu.com","title":"马明祥到此一游","topicId":"a69abb62e4a9454ebfe6235ee77ffd66"}]
     */

    private String cursor;
    private List<FavouritTopicListBean> favouritTopicList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritTopicListBean> getFavouritTopicList() {
        return favouritTopicList;
    }

    public void setFavouritTopicList(List<FavouritTopicListBean> favouritTopicList) {
        this.favouritTopicList = favouritTopicList;
    }

    public static class FavouritTopicListBean {
        /**
         * comments : 1
         * imageListThumb : null
         * likes : 1
         * pageviews : 9
         * publishTime : 2019-02-14
         * shareLink : http://www.baidu.com
         * title : 恐惧魔王
         * topicId : c36d3c6cc3a84d9493b62e5cc2949418
         */

        private int comments;
        private Object imageListThumb;
        private int likes;
        private int pageviews;
        private String publishTime;
        private String shareLink;
        private String title;
        private String topicId;

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public Object getImageListThumb() {
            return imageListThumb;
        }

        public void setImageListThumb(Object imageListThumb) {
            this.imageListThumb = imageListThumb;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
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
    }
}
