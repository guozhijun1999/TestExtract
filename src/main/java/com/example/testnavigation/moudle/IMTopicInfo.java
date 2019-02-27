package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.Favourite;
import com.example.testnavigation.brean.inform.Follow;
import com.example.testnavigation.brean.inform.Like;
import com.example.testnavigation.brean.topic.ListComment;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.brean.topic.TopicDetailsBean;
import com.example.testnavigation.brean.topic.UserComment;
import com.example.testnavigation.contact.LoadTopic;
import com.example.testnavigation.contact.NewsInfo;
import com.example.testnavigation.contact.TopicInfo;
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
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMTopicInfo {

    public void getTopicinfoList(String TopicId, String newId, final TopicInfo.TopicInfoCallBak topicInfoCallBak){
        RequestBody requestBody = new FormBody.Builder()
                .add("topicId", TopicId)
                .add("userId", newId)
                .build();
        HttpManager.getInstance().getServer().getTopicinfo(requestBody)
                .compose(RxUtils.<HttpResponse<TopicDetailsBean>>rxScheduleThread())
                .compose(RxUtils.<TopicDetailsBean>handeResult())
                .subscribe(new BaseObserver<TopicDetailsBean>(topicInfoCallBak) {
                    @Override
                    public void onNext(TopicDetailsBean value) {
                        topicInfoCallBak.setTopicInfoTab(value);
                    }
                });
    }

    public void getListComment(String objectId, String objectType, String cursor, final TopicInfo.TopicInfoCallBak topicInfoCallBak){
        ListComment listComment = new ListComment();
        listComment.setObjectId(objectId);
        listComment.setObjectType(objectType);
        listComment.setCursor(cursor);
        Gson gson = new Gson();
        String s = gson.toJson(listComment);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getListComment(requestBody)
                .compose(RxUtils.<HttpResponse<ListCommentBean>>rxScheduleThread())
                .compose(RxUtils.<ListCommentBean>handeResult())
                .subscribe(new BaseObserver<ListCommentBean>(topicInfoCallBak) {
                    @Override
                    public void onNext(ListCommentBean value) {
                        topicInfoCallBak.setListCommentTab(value);
                    }
                });
    }

    public void getUserComment(String userId, String objectId, String objectType, String content, final TopicInfo.TopicInfoCallBak topicInfoCallBak){
        UserComment userComment = new UserComment();
        userComment.setUserId(userId);
        userComment.setObjectId(objectId);
        userComment.setObjectType(objectType);
        userComment.setContent(content);
        Gson gson = new Gson();
        String s = gson.toJson(userComment);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getUserComment(requestBody)
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
                }).subscribe(new BaseObserver<String>(topicInfoCallBak) {
            @Override
            public void onNext(String value) {
                topicInfoCallBak.setUserComment();
            }
        });
    }

    public void getLike(String userId, String objectId, String objectType, String type,final TopicInfo.TopicInfoCallBak topicInfoCallBak){
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
                }).subscribe(new BaseObserver<String>(topicInfoCallBak) {
            @Override
            public void onNext(String value) {
                topicInfoCallBak.setLike();
            }
        });
    }

    public void getFollow(String userId, String followUid, String type,final TopicInfo.TopicInfoCallBak topicInfoCallBak){
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
                }).subscribe(new BaseObserver<String>(topicInfoCallBak) {
            @Override
            public void onNext(String value) {
                topicInfoCallBak.setFollow();
            }
        });
    }
    public void getFavourite(String userId, String objectId, String objectType, String type,final TopicInfo.TopicInfoCallBak topicInfoCallBak){
        Favourite favourite = new Favourite();
        favourite.setUserId(userId);
        favourite.setObjectId(objectId);
        favourite.setObjectType(objectType);
        favourite.setType(type);
        Gson gson = new Gson();
        String s = gson.toJson(favourite);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getFavourite(requestBody)
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
                }).subscribe(new BaseObserver<String>(topicInfoCallBak) {
            @Override
            public void onNext(String value) {
                topicInfoCallBak.setFavourite();
            }
        });
    }
}
