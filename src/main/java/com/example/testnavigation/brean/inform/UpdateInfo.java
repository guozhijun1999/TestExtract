package com.example.testnavigation.brean.inform;

/**
 * Created by 88888 on 2019/1/21.
 */

public class UpdateInfo {
    String userId;
    String birthday;
    Object nickname;
    String personalProfile;
    String professionId;
    String sex;

    public UpdateInfo() {
        super();
    }

    public UpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex) {
        this.userId = userId;
        this.birthday = birthday;
        this.nickname = nickname;
        this.personalProfile = personalProfile;
        this.professionId = professionId;
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
