package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.FastLoginBean;
import com.example.testnavigation.brean.mine.Fastlogin;
import com.example.testnavigation.contact.FastLogin;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMFastLogin {
    public void getFastLogin(String userId, String platform, String appVersion, final FastLogin.FastLoginCallBak fastLoginCallBak){
        Fastlogin fastlogin = new Fastlogin();
        fastlogin.setUserId(userId);
        fastlogin.setPlatform(platform);
        fastlogin.setAppVersion(appVersion);
        Gson gson = new Gson();
        String s = gson.toJson(fastlogin);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getFastLogin(requestBody).compose(RxUtils.<HttpResponse<FastLoginBean>>rxScheduleThread())
                .compose(RxUtils.<FastLoginBean>handeResult())
                .subscribe(new BaseObserver<FastLoginBean>(fastLoginCallBak) {
                    @Override
                    public void onNext(FastLoginBean value) {
                        fastLoginCallBak.setFastLoginTab(value);
                    }
                });
    }
}
