package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.Demo;
import com.example.testnavigation.brean.inform.DownListNews;
import com.example.testnavigation.contact.IDownListNews;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IDownListNewsM {
    public void getDownListNews(String url, String channelId, String page, final IDownListNews.DownListNewsCallBak downListNewsCallBak){
        Demo demo = new Demo();
        demo.setChannelId(channelId);
        demo.setCursor(page);
        Gson gson = new Gson();
        String s = gson.toJson(demo);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getNewsDetails(url,requestBody,"application/json")
                .compose(RxUtils.<HttpResponse<DownListNews>>rxScheduleThread())
                .compose(RxUtils.<DownListNews>handeResult())
                .subscribe(new BaseObserver<DownListNews>(downListNewsCallBak) {
                    @Override
                    public void onNext(DownListNews value) {
                        List<DownListNews.NewListBean> newList = value.getNewList();
                        downListNewsCallBak.setDownListNews(newList);
                    }
                });
    }
}
