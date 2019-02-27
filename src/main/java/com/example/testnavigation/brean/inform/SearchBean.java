package com.example.testnavigation.brean.inform;

import java.util.List;

public class SearchBean {

    /**
     * code : 0
     * data : {"cursor":"152959680024fdb67c1f3940968d9aecb95a8f290d","newList":[{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201806/28/110827byitiatxuafaufxi.jpg.thumb.jpg"],"layoutType":"2","newsId":"94feae58307648478caf4ff57c66689a","origin":"","pageviews":0,"publishTime":"2018-06-28","title":"陕西铜川公安局采取四项措施强化无人机治安管理"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201806/28/104434bg7n6cn2dgv4gu4c.jpg.thumb.jpg"],"layoutType":"2","newsId":"1c429ea8d3a349a196dad60a69c33c6f","origin":"","pageviews":0,"publishTime":"2018-06-28","title":"直升机无人机齐上阵！潍坊峡山水库蝗情防控面积突破4万亩"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180627/1_180627224152_1-lp.jpg"],"layoutType":"1","newsId":"8127a8eaf9634fa4aea7ef7c3fa4b9e7","origin":"","pageviews":0,"publishTime":"2018-06-27","title":"通用原子公司将首次进行无人机跨大西洋飞行"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180625/1_180625171803_1-lp.jpg"],"layoutType":"1","newsId":"1dd7aaec95af4d1dae669503e8d57897","origin":"","pageviews":0,"publishTime":"2018-06-25","title":"无人机空管与机场安保论坛在深成功举办"},{"imageListThumb":["http://www.ga.cn/images/defaultpic.gif"],"layoutType":"1","newsId":"ba03f14ae9da4644b75a8723db587088","origin":"","pageviews":0,"publishTime":"2018-06-24","title":"波音注资无人机基础设施开发商"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201806/22/0416083012255.jpg"],"layoutType":"1","newsId":"273bd3b0ddfb46c4bac7ee37b0bef58c","origin":"","pageviews":0,"publishTime":"2018-06-22","title":"直接击落！美国通过反无人机法案"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201806/22/0410184412255.jpg"],"layoutType":"1","newsId":"24fdb67c1f3940968d9aecb95a8f290d","origin":"","pageviews":0,"publishTime":"2018-06-22","title":"法国民航总局新规：玩无人机必须先接受培训"}]}
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
         * cursor : 152959680024fdb67c1f3940968d9aecb95a8f290d
         * newList : [{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201806/28/110827byitiatxuafaufxi.jpg.thumb.jpg"],"layoutType":"2","newsId":"94feae58307648478caf4ff57c66689a","origin":"","pageviews":0,"publishTime":"2018-06-28","title":"陕西铜川公安局采取四项措施强化无人机治安管理"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201806/28/104434bg7n6cn2dgv4gu4c.jpg.thumb.jpg"],"layoutType":"2","newsId":"1c429ea8d3a349a196dad60a69c33c6f","origin":"","pageviews":0,"publishTime":"2018-06-28","title":"直升机无人机齐上阵！潍坊峡山水库蝗情防控面积突破4万亩"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180627/1_180627224152_1-lp.jpg"],"layoutType":"1","newsId":"8127a8eaf9634fa4aea7ef7c3fa4b9e7","origin":"","pageviews":0,"publishTime":"2018-06-27","title":"通用原子公司将首次进行无人机跨大西洋飞行"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180625/1_180625171803_1-lp.jpg"],"layoutType":"1","newsId":"1dd7aaec95af4d1dae669503e8d57897","origin":"","pageviews":0,"publishTime":"2018-06-25","title":"无人机空管与机场安保论坛在深成功举办"},{"imageListThumb":["http://www.ga.cn/images/defaultpic.gif"],"layoutType":"1","newsId":"ba03f14ae9da4644b75a8723db587088","origin":"","pageviews":0,"publishTime":"2018-06-24","title":"波音注资无人机基础设施开发商"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201806/22/0416083012255.jpg"],"layoutType":"1","newsId":"273bd3b0ddfb46c4bac7ee37b0bef58c","origin":"","pageviews":0,"publishTime":"2018-06-22","title":"直接击落！美国通过反无人机法案"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201806/22/0410184412255.jpg"],"layoutType":"1","newsId":"24fdb67c1f3940968d9aecb95a8f290d","origin":"","pageviews":0,"publishTime":"2018-06-22","title":"法国民航总局新规：玩无人机必须先接受培训"}]
         */

        private String cursor;
        private List<NewListBean> newList;

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<NewListBean> getNewList() {
            return newList;
        }

        public void setNewList(List<NewListBean> newList) {
            this.newList = newList;
        }

        public static class NewListBean {
            /**
             * imageListThumb : ["http://www.lyunx.com/data/attachment/portal/201806/28/110827byitiatxuafaufxi.jpg.thumb.jpg"]
             * layoutType : 2
             * newsId : 94feae58307648478caf4ff57c66689a
             * origin :
             * pageviews : 0
             * publishTime : 2018-06-28
             * title : 陕西铜川公安局采取四项措施强化无人机治安管理
             */

            private String layoutType;
            private String newsId;
            private String origin;
            private int pageviews;
            private String publishTime;
            private String title;
            private List<String> imageListThumb;

            public String getLayoutType() {
                return layoutType;
            }

            public void setLayoutType(String layoutType) {
                this.layoutType = layoutType;
            }

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
