package com.example.testnavigation.brean.inform;

import java.util.List;

public class UpListNews {

    /**
     * maxCursor : 152574552003ca4730d3f349d1bee3a3b409f03bc8
     * tops : 0
     * newList : [{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201805/08/101125yui3awluagrriegr.jpg.thumb.jpg"],"isTop":0,"layoutType":"1","newsId":"03ca4730d3f349d1bee3a3b409f03bc8","origin":"","pageviews":350,"publishTime":"2018-05-08","title":"航空器国籍和适航证件系统5月7日起正式启用"},{"imageListThumb":["null"],"isTop":0,"layoutType":"0","newsId":"a4e3086bf8fd4eabbad66fe3eb695257","origin":"","pageviews":103,"publishTime":"2018-05-05","title":"关注丨民航局研究部署，推进通用航空试点工作"},{"imageListThumb":["http://www.lyunx.com/data/attachment/portal/201805/04/112318nw9wq6pcrpx1o5oj.jpg.thumb.jpg"],"isTop":0,"layoutType":"1","newsId":"272c8a46acec4a6f942145396fc83ca7","origin":"","pageviews":159,"publishTime":"2018-05-04","title":"民航局适航司关于发布改进通用航空适航审定政策实施细则的通知"},{"imageListThumb":["http://www.ga.cn/uploads/allimg/180503/1_180503231542_1-lp.jpg"],"isTop":0,"layoutType":"1","newsId":"7df06601f4b945c090d81541e766893a","origin":"","pageviews":66,"publishTime":"2018-05-03","title":"通用航空再迎新利好！中国民航局在金普新区举办培训班解读新政策"},{"imageListThumb":["null"],"isTop":0,"layoutType":"0","newsId":"85a0835f2cbb46b9bf417fd52f3fb521","origin":"","pageviews":55,"publishTime":"2018-05-03","title":"关注丨《民航局适航司关于改进 通用航空适航审定政策实施细则》"},{"imageListThumb":["http://cn.ttfly.com/file/upload/201804/26/193531851.jpg"],"isTop":0,"layoutType":"1","newsId":"eb8cde1369334589966b305e6f17680e","origin":"","pageviews":68,"publishTime":"2018-04-27","title":"通航人都会收藏的全国通用机场建设4月盘点"},{"imageListThumb":["null"],"isTop":0,"layoutType":"0","newsId":"f2ab56c62ad340debb9925b90dfdcd39","origin":"","pageviews":11,"publishTime":"2018-04-26","title":"政策出台运营便捷化，通航企业可通过邮箱反馈运行中发现的问题"}]
     * minCursor : 1524672000f2ab56c62ad340debb9925b90dfdcd39
     */

    private String maxCursor;
    private int tops;
    private String minCursor;
    private List<NewListBean> newList;

    public String getMaxCursor() {
        return maxCursor;
    }

    public void setMaxCursor(String maxCursor) {
        this.maxCursor = maxCursor;
    }

    public int getTops() {
        return tops;
    }

    public void setTops(int tops) {
        this.tops = tops;
    }

    public String getMinCursor() {
        return minCursor;
    }

    public void setMinCursor(String minCursor) {
        this.minCursor = minCursor;
    }

    public List<NewListBean> getNewList() {
        return newList;
    }

    public void setNewList(List<NewListBean> newList) {
        this.newList = newList;
    }

    public static class NewListBean {
        /**
         * imageListThumb : ["http://www.lyunx.com/data/attachment/portal/201805/08/101125yui3awluagrriegr.jpg.thumb.jpg"]
         * isTop : 0
         * layoutType : 1
         * newsId : 03ca4730d3f349d1bee3a3b409f03bc8
         * origin :
         * pageviews : 350
         * publishTime : 2018-05-08
         * title : 航空器国籍和适航证件系统5月7日起正式启用
         */

        private int isTop;
        private String layoutType;
        private String newsId;
        private String origin;
        private int pageviews;
        private String publishTime;
        private String title;
        private List<String> imageListThumb;

        public int getIsTop() {
            return isTop;
        }

        public void setIsTop(int isTop) {
            this.isTop = isTop;
        }

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
