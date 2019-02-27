package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.SearchDemo;
import com.example.testnavigation.brean.topic.SousuoinfoBean;
import com.example.testnavigation.contact.SearchInfo;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMSearchInfo {
    public void getSousuoinfo(String key,final SearchInfo.SearchInfoCallBak searchInfoCallBak){
        SearchDemo searchDemo = new SearchDemo();
        searchDemo.setKeyword(key);
        searchDemo.setCursor("0");
        Gson gson = new Gson();
        String s = gson.toJson(searchDemo);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getsousuoinfo(requestBody)
                .compose(RxUtils.<SousuoinfoBean>rxScheduleThread())
                .subscribe(new BaseObserver<SousuoinfoBean>(searchInfoCallBak) {
                    @Override
                    public void onNext(SousuoinfoBean value) {
                        searchInfoCallBak.setSousuo(value);
                    }
                });

    }
}
