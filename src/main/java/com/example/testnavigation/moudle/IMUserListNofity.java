package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.contact.ListNotify;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class IMUserListNofity {
    public void getUserListNofity(String userId, final ListNotify.ListNotifyCallBak listNotifyCallBak){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId", userId)
                .build();
        HttpManager.getInstance().getServer().getListNotify(requestBody).compose(RxUtils.<ListNotifyBean>rxScheduleThread())
                .subscribe(new BaseObserver<ListNotifyBean>(listNotifyCallBak) {
                    @Override
                    public void onNext(ListNotifyBean value) {
                        listNotifyCallBak.setListNotifyTab(value);
                    }
                });
    }
}
