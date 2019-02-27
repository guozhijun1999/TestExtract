package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearch;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.TagsHot;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IMTagsHot {
    public void getTagsHot(final TagsHot.TagsHotCallBak tagsHotCallBak){
        RequestBody requestBody=RequestBody.create(MediaType.parse(""),"");
        HttpManager.getInstance().getServer().getTagsHot(requestBody)
                .compose(RxUtils.<TagsHotBean>rxScheduleThread())
                .subscribe(new BaseObserver<TagsHotBean>(tagsHotCallBak) {
                    @Override
                    public void onNext(TagsHotBean value) {
                        tagsHotCallBak.setTagsHotTab(value);
                    }
                });
    }

    public void getTagSearch(String keyword, String cursor, final TagsHot.TagsHotCallBak tagsHotCallBak){
        TagsSearch tagsSearch=new TagsSearch();
        tagsSearch.setKeyword(keyword);
        tagsSearch.setCursor(cursor);
        Gson gson = new Gson();
        String s = gson.toJson(tagsSearch);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getTagsSearch(requestBody)
                .compose(RxUtils.<HttpResponse<TagsSearchBean>>rxScheduleThread())
                .compose(RxUtils.<TagsSearchBean>handeResult())
                .subscribe(new BaseObserver<TagsSearchBean>(tagsHotCallBak) {
                    @Override
                    public void onNext(TagsSearchBean value) {
                        tagsHotCallBak.setTagsSearchTab(value);
                    }
                });
    }
}
