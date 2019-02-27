package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchDemo;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.contact.SearchListBean;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMSearchListBean {
    public void getHot(final SearchListBean.SearchListBeanCallBak listBeanCallBak) {
        RequestBody requestBody=RequestBody.create(MediaType.parse(""),"");
        HttpManager.getInstance().getServer().getHot(requestBody)
                .compose(RxUtils.<HotBean>rxScheduleThread())
                .subscribe(new BaseObserver<HotBean>(listBeanCallBak) {
                    @Override
                    public void onNext(HotBean value) {
                        listBeanCallBak.setHotList(value);
                    }
                });
    }

    public void getseach(final SearchListBean.SearchListBeanCallBak listBeanCallBak,String key){
        SearchDemo searchDemo = new SearchDemo();
        searchDemo.setKeyword(key);
        searchDemo.setCursor("0");
        Gson gson = new Gson();
        String s = gson.toJson(searchDemo);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getSearchNews(requestBody)
                .compose(RxUtils.<SearchBean>rxScheduleThread())
                .subscribe(new BaseObserver<SearchBean>(listBeanCallBak) {
                    @Override
                    public void onNext(SearchBean value) {
                        listBeanCallBak.setSearchList(value);
                    }
                });
    }

    public void getSearchTopicList(final SearchListBean.SearchListBeanCallBak listBeanCallBak,String key){
        SearchDemo searchDemo = new SearchDemo();
        searchDemo.setKeyword(key);
        searchDemo.setCursor("0");
        Gson gson = new Gson();
        String s = gson.toJson(searchDemo);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getSearchTopic(requestBody)
                .compose(RxUtils.<SearchTopicBean>rxScheduleThread())
                .subscribe(new BaseObserver<SearchTopicBean>(listBeanCallBak) {
                    @Override
                    public void onNext(SearchTopicBean value) {
                        listBeanCallBak.setSearchTopicList(value);
                    }
                });
    }
}
