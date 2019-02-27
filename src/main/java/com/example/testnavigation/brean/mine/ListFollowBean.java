package com.example.testnavigation.brean.mine;

import java.util.List;

/**
 * Created by 88888 on 2019/2/4.
 */

public class ListFollowBean {

    private List<FollowListBean> followList;

    public List<FollowListBean> getFollowList() {
        return followList;
    }

    public void setFollowList(List<FollowListBean> followList) {
        this.followList = followList;
    }

    public static class FollowListBean {
        /**
         * followId : 7caa8aea942045a1bf9e5e5d9f0159f9
         * followTime : 2018-11-22
         * followUid : 9f6a2e6358be4be1ad89eefa17f27a7e
         * headImagePath : http://39.107.254.232/firstga/imagesnull
         * nickname : null
         * personalProfile : null
         */

        private String followId;
        private String followTime;
        private String followUid;
        private String headImagePath;
        private Object nickname;
        private Object personalProfile;

        public String getFollowId() {
            return followId;
        }

        public void setFollowId(String followId) {
            this.followId = followId;
        }

        public String getFollowTime() {
            return followTime;
        }

        public void setFollowTime(String followTime) {
            this.followTime = followTime;
        }

        public String getFollowUid() {
            return followUid;
        }

        public void setFollowUid(String followUid) {
            this.followUid = followUid;
        }

        public String getHeadImagePath() {
            return headImagePath;
        }

        public void setHeadImagePath(String headImagePath) {
            this.headImagePath = headImagePath;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public Object getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(Object personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
