package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.ListTopicBean;
import com.example.testnavigation.contact.UserListTopic;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class IMUserListTopic {
    public void getUserListTopic(String userId, String cursor, final UserListTopic.UserListTopicCallBak listTopicCallBak) {
        RequestBody requestBody = new FormBody.Builder()
                .add("userId", userId)
                .add("cursor", cursor)
                .build();
        HttpManager.getInstance().getServer().getListTopic(requestBody).compose(RxUtils.<HttpResponse<ListTopicBean>>rxScheduleThread())
                .compose(RxUtils.<ListTopicBean>handeResult())
                .subscribe(new BaseObserver<ListTopicBean>(listTopicCallBak) {
                    @Override
                    public void onNext(ListTopicBean value) {
                        listTopicCallBak.setUserListTopicTab(value);
                    }
                });
    }
}
