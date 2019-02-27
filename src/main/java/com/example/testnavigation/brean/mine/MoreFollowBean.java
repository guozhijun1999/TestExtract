package com.example.testnavigation.brean.mine;

import java.util.List;

/**
 * Created by 88888 on 2019/2/12.
 */

public class MoreFollowBean {

    /**
     * cursor : 0
     * moreFollowList : [{"followers":11,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-05-21/cb2fa1f12fe644f88a6aff44fc0243c3_1526894227477.jpg","nickname":"虎皮猫大人","userId":"cb2fa1f12fe644f88a6aff44fc0243c3"},{"followers":11,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-01-29/9f6f3213b02244439d8d119e49aee364_1548733643933.png","nickname":"null","userId":"9f6f3213b02244439d8d119e49aee364"},{"followers":7,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-05-21/392cbe1d4c6e4b0094f84bad059c8793_1526893725568.jpg","nickname":"一航","userId":"392cbe1d4c6e4b0094f84bad059c8793"},{"followers":6,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-05-18/6eab9706613f4d3486642bdf80007ad4_1526632010149.jpg","nickname":"小蜗牛","userId":"6eab9706613f4d3486642bdf80007ad4"},{"followers":5,"headImagePath":"http://39.107.254.232/firstga/images/head/2019-02-12/e8bbadbd51c44a139c789fb1ef062b94_1549928792216.jpg","nickname":"王耀82571459","userId":"e8bbadbd51c44a139c789fb1ef062b94"},{"followers":3,"headImagePath":"http://39.107.254.232/firstga/images/head/2018-09-19/97400cb644f345f3aa888ec116ef1b58_1537351450665.jpg","nickname":"Haou","userId":"97400cb644f345f3aa888ec116ef1b58"}]
     */

    private String cursor;
    private List<MoreFollowListBean> moreFollowList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<MoreFollowListBean> getMoreFollowList() {
        return moreFollowList;
    }

    public void setMoreFollowList(List<MoreFollowListBean> moreFollowList) {
        this.moreFollowList = moreFollowList;
    }

    public static class MoreFollowListBean {
        /**
         * followers : 11
         * headImagePath : http://39.107.254.232/firstga/images/head/2018-05-21/cb2fa1f12fe644f88a6aff44fc0243c3_1526894227477.jpg
         * nickname : 虎皮猫大人
         * userId : cb2fa1f12fe644f88a6aff44fc0243c3
         */

        private int followers;
        private String headImagePath;
        private String nickname;
        private String userId;

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
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
