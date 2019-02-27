package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;
import com.example.testnavigation.brean.mine.FavouriteTopicBean;
import com.example.testnavigation.contact.UserFavourite;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class IMUserFavourite {
    public void getUserFavouriteNews(String userId, String cursor, final UserFavourite.UserFavouriteCallBak userFavouriteCallBak) {
        RequestBody requestBody=new FormBody.Builder()
                .addEncoded("userId",userId)
                .addEncoded("cursor",cursor)
                .build();
        HttpManager.getInstance().getServer().getFavouriteNews(requestBody)
                .compose(RxUtils.<HttpResponse<FavouriteNewsBean>>rxScheduleThread())
                .compose(RxUtils.<FavouriteNewsBean>handeResult())
                .subscribe(new BaseObserver<FavouriteNewsBean>(userFavouriteCallBak) {
                    @Override
                    public void onNext(FavouriteNewsBean value) {
                        userFavouriteCallBak.setUserFavouriteNewsTab(value);
                    }
                });

    }

    public void getUserFavouriteTopic(String userId, String cursor, final UserFavourite.UserFavouriteCallBak userFavouriteCallBak) {
        RequestBody requestBody=new FormBody.Builder()
                .addEncoded("userId",userId)
                .addEncoded("cursor",cursor)
                .build();
        HttpManager.getInstance().getServer().getFavouriteTopic(requestBody).compose(RxUtils.<HttpResponse<FavouriteTopicBean>>rxScheduleThread())
                .compose(RxUtils.<FavouriteTopicBean>handeResult())
                .subscribe(new BaseObserver<FavouriteTopicBean>(userFavouriteCallBak) {
                    @Override
                    public void onNext(FavouriteTopicBean value) {
                        userFavouriteCallBak.setUserFavouriteTopicTab(value);
                    }
                });
    }
}
