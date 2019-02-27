package com.example.testnavigation.brean.mine;

/**
 * Created by 88888 on 2019/2/2.
 */

public class Fastlogin {
        String userId;
        String platform;

    public Fastlogin() {
        super();
    }

    public Fastlogin(String userId, String platform, String appVersion) {
        this.userId = userId;
        this.platform = platform;
        this.appVersion = appVersion;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    String appVersion;
}
