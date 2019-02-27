package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.ListFollowBean;
import com.example.testnavigation.contact.UserListFollow;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class IMUserListFollow {
    public void getUserListFollow(String userId, final UserListFollow.ListFollowCallBak listFollowCallBak){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId", userId)
                .build();
        HttpManager.getInstance().getServer().getListFollow(requestBody).compose(RxUtils.<HttpResponse<ListFollowBean>>rxScheduleThread())
                .compose(RxUtils.<ListFollowBean>handeResult())
                .subscribe(new BaseObserver<ListFollowBean>(listFollowCallBak) {
                    @Override
                    public void onNext(ListFollowBean value) {
                        listFollowCallBak.setListFollowTab(value);
                    }
                });
    }
}
