package com.example.testnavigation.moudle;

import android.util.Log;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.Follow;
import com.example.testnavigation.brean.mine.MoreFollowBean;
import com.example.testnavigation.brean.mine.MoreFollowb;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearch;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.LoadTopic;
import com.example.testnavigation.contact.MoreFollow;
import com.example.testnavigation.contact.TagsHot;
import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMMoreFollow {
    public void geTagsHot(final MoreFollow.MoreFollowCallBak moreFollowCallBak) {
        RequestBody requestBody=RequestBody.create(MediaType.parse(""),"");
        HttpManager.getInstance().getServer().getTagsHot(requestBody).compose(RxUtils.<TagsHotBean>rxScheduleThread())
                .subscribe(new BaseObserver<TagsHotBean>(moreFollowCallBak) {
                    @Override
                    public void onNext(TagsHotBean value) {
                        moreFollowCallBak.setTagsHotTab(value);
                    }
                });
    }

    public void getMoreFollow(String userId, String tagId, String cursor, final MoreFollow.MoreFollowCallBak moreFollowCallBak) {
        MoreFollowb moreFollowb = new MoreFollowb();
        moreFollowb.setUserId(userId);
        moreFollowb.setTagId(tagId);
        moreFollowb.setCursor(cursor);
        Gson gson = new Gson();
        String s = gson.toJson(moreFollowb);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getMoreFollow(requestBody).compose(RxUtils.<HttpResponse<MoreFollowBean>>rxScheduleThread())
                .compose(RxUtils.<MoreFollowBean>handeResult())
                .subscribe(new BaseObserver<MoreFollowBean>(moreFollowCallBak) {
                    @Override
                    public void onNext(MoreFollowBean value) {
                        moreFollowCallBak.setMoreFollowTab(value);
                    }
                });
    }
    public void getFollow(String userId, String followUid, String type,final MoreFollow.MoreFollowCallBak moreFollowCallBak){
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
                }).subscribe(new BaseObserver<String>(moreFollowCallBak) {
            @Override
            public void onNext(String value) {
                moreFollowCallBak.setFollow();
            }
        });
    }

    public void getTagSearch(String keyword, String cursor, final MoreFollow.MoreFollowCallBak moreFollowCallBak){
        TagsSearch tagsSearch=new TagsSearch();
        tagsSearch.setKeyword(keyword);
        tagsSearch.setCursor(cursor);
        Gson gson = new Gson();
        String s = gson.toJson(tagsSearch);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getTagsSearch(requestBody)
                .compose(RxUtils.<HttpResponse<TagsSearchBean>>rxScheduleThread())
                .compose(RxUtils.<TagsSearchBean>handeResult())
                .subscribe(new BaseObserver<TagsSearchBean>(moreFollowCallBak) {
                    @Override
                    public void onNext(TagsSearchBean value) {
                        moreFollowCallBak.setTagsSearchTab(value);
                    }
                });
    }
}
