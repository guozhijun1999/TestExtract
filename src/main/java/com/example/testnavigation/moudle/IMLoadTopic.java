package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.Follow;
import com.example.testnavigation.brean.inform.Like;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.brean.topic.Topic;
import com.example.testnavigation.contact.LoadTopic;
import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMLoadTopic {
    public void getLoadTopic(String type, String cursor, String userId, String tagId, final LoadTopic.LoadTopicCallBak loadTopicCallBak){
        Topic topic = new Topic();
        topic.setType(type);
        topic.setCursor(cursor);
        topic.setUserId(userId);
        topic.setTagId(tagId);
        Gson gson = new Gson();
        String s = gson.toJson(topic);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getLoadTopic(requestBody)
                .compose(RxUtils.<HttpResponse<LoadTopicBean>>rxScheduleThread())
                .compose(RxUtils.<LoadTopicBean>handeResult())
                .subscribe(new BaseObserver<LoadTopicBean>(loadTopicCallBak) {
                    @Override
                    public void onNext(LoadTopicBean value) {
                        loadTopicCallBak.setLoadTopicTab(value);
                    }
                });
    }

    public void getLike(String userId, String objectId, String objectType, String type,final LoadTopic.LoadTopicCallBak loadTopicCallBak){
        Like like = new Like();
        like.setUserId(userId);
        like.setObjectId(objectId);
        like.setObjectType(objectType);
        like.setType(type);
        Gson gson = new Gson();
        String s = gson.toJson(like);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getLike(requestBody)
                .compose(RxUtils.<HttpResponse>rxScheduleThread())
                .flatMap(new Function<HttpResponse, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final HttpResponse httpResponse) throws Exception {
                        if (httpResponse.getCode() != 0){
                            return Observable.error(new ApiException(httpResponse.getCode(), httpResponse.getMessage()));
                        }else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(httpResponse.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(loadTopicCallBak) {
            @Override
            public void onNext(String value) {
                loadTopicCallBak.setLike();
            }
        });
    }

    public void getFollow(String userId, String followUid, String type,final LoadTopic.LoadTopicCallBak loadTopicCallBak){
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowUid(followUid);
        follow.setType(type);
        Gson gson = new Gson();
        String s = gson.toJson(follow);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getFollow(requestBody)
                .compose(RxUtils.<HttpResponse>rxScheduleThread())
                .flatMap(new Function<HttpResponse, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final HttpResponse httpResponse) throws Exception {
                        if (httpResponse.getCode() != 0){
                            return Observable.error(new ApiException(httpResponse.getCode(), httpResponse.getMessage()));
                        }else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(httpResponse.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(loadTopicCallBak) {
            @Override
            public void onNext(String value) {
                loadTopicCallBak.setFollow();
            }
        });
    }
}
