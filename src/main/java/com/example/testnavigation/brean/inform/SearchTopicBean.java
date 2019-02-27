package com.example.testnavigation.brean.inform;

import java.util.List;

public class SearchTopicBean {

    /**
     * code : 0
     * data : {"cursor":"15280763572929cc6309ede544b19b2597d170474236b","topicList":[{"comments":2,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png","imageListThumb":["http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455587785.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588051.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588301.jpg"],"likes":6,"nickname":"null","pageviews":137,"publishTime":"2018-06-20","shareLink":"","title":"【独角兽能否助力空域开放？】今年618京东第一架重型无人机正式下线！目标有效载重量达到1-5吨！飞行距离超过1000公里！100%自主知识产权！同样在618这一天，京东超重型无人机项目正式立项，目标有效载重量达到40-60吨，飞行距离超过6000公里！","topicId":"3f9ffca2706c4ebeb11a9607e1b604ea","userId":"9f6f3213b02244439d8d119e49aee364"},{"comments":8,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png","imageListThumb":["http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076356717.jpg","http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076356956.jpg","http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076357181.jpg"],"likes":1,"nickname":"null","pageviews":114,"publishTime":"2018-06-04","shareLink":"","title":"【系统上线一天 25家企业获得无人机经营许可证】6月1日，《民用无人驾驶航空器经营性飞行活动管理办法（暂行）》正式实施，\u201c民用无人驾驶航空器经营许可证管理系统\u201d也于同日上线，上线当日共有328家单位在线提交了许可申请。在当天获得经营许可证的25家企业中，注册地全部分布在华北和华东地区","topicId":"9cc6309ede544b19b2597d170474236b","userId":"9f6f3213b02244439d8d119e49aee364"}]}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * cursor : 15280763572929cc6309ede544b19b2597d170474236b
         * topicList : [{"comments":2,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png","imageListThumb":["http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455587785.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588051.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588301.jpg"],"likes":6,"nickname":"null","pageviews":137,"publishTime":"2018-06-20","shareLink":"","title":"【独角兽能否助力空域开放？】今年618京东第一架重型无人机正式下线！目标有效载重量达到1-5吨！飞行距离超过1000公里！100%自主知识产权！同样在618这一天，京东超重型无人机项目正式立项，目标有效载重量达到40-60吨，飞行距离超过6000公里！","topicId":"3f9ffca2706c4ebeb11a9607e1b604ea","userId":"9f6f3213b02244439d8d119e49aee364"},{"comments":8,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png","imageListThumb":["http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076356717.jpg","http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076356956.jpg","http://39.107.254.232/firstga/images/topic/2018-06-04/9f6f3213b02244439d8d119e49aee364_1528076357181.jpg"],"likes":1,"nickname":"null","pageviews":114,"publishTime":"2018-06-04","shareLink":"","title":"【系统上线一天 25家企业获得无人机经营许可证】6月1日，《民用无人驾驶航空器经营性飞行活动管理办法（暂行）》正式实施，\u201c民用无人驾驶航空器经营许可证管理系统\u201d也于同日上线，上线当日共有328家单位在线提交了许可申请。在当天获得经营许可证的25家企业中，注册地全部分布在华北和华东地区","topicId":"9cc6309ede544b19b2597d170474236b","userId":"9f6f3213b02244439d8d119e49aee364"}]
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
             * comments : 2
             * headImagePath : http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png
             * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455587785.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588051.jpg","http://39.107.254.232/firstga/images/topic/2018-06-20/9f6f3213b02244439d8d119e49aee364_1529455588301.jpg"]
             * likes : 6
             * nickname : null
             * pageviews : 137
             * publishTime : 2018-06-20
             * shareLink :
             * title : 【独角兽能否助力空域开放？】今年618京东第一架重型无人机正式下线！目标有效载重量达到1-5吨！飞行距离超过1000公里！100%自主知识产权！同样在618这一天，京东超重型无人机项目正式立项，目标有效载重量达到40-60吨，飞行距离超过6000公里！
             * topicId : 3f9ffca2706c4ebeb11a9607e1b604ea
             * userId : 9f6f3213b02244439d8d119e49aee364
             */

            private int comments;
            private String headImagePath;
            private int likes;
            private String nickname;
            private int pageviews;
            private String publishTime;
            private String shareLink;
            private String title;
            private String topicId;
            private String userId;
            private List<String> imageListThumb;

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

            public List<String> getImageListThumb() {
                return imageListThumb;
            }

            public void setImageListThumb(List<String> imageListThumb) {
                this.imageListThumb = imageListThumb;
            }
        }
    }
}
