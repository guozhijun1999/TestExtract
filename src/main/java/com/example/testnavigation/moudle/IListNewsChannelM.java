package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.contact.IListNewsChannel;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.RxUtils;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IListNewsChannelM {
    public void getListNewsChanne(String json, final IListNewsChannel.ListNewsChannelCallBak listNewsChannelCallBak){
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/x-www-form-urlencoded,charset-UTF-8"),"");
        HttpManager.getInstance().getServer().getPost(json,requestBody,"application/x-www-form-urlencoded")
                .compose(RxUtils.<HttpResponse<ListNewsChannel>>rxScheduleThread())
                .compose(RxUtils.<ListNewsChannel>handeResult())
                .subscribe(new BaseObserver<ListNewsChannel>(listNewsChannelCallBak) {
                    @Override
                    public void onNext(ListNewsChannel value) {
                        List<ListNewsChannel.NewsChannelListBean> newsChannelList = value.getNewsChannelList();
                        listNewsChannelCallBak.setListTab(newsChannelList);
                    }
                });
    }
}
