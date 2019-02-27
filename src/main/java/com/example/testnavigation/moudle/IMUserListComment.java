package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.mine.UserListCommentBean;
import com.example.testnavigation.contact.UserListComment;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;

import okhttp3.FormBody;
import okhttp3.RequestBody;


public class IMUserListComment {
    public void getUserListComment(String userId, final UserListComment.ListCommentCallBak listCommentCallBak){
        RequestBody requestBody = new FormBody.Builder()
                .add("userId",userId)
                .build();
        HttpManager.getInstance().getServer().getUserListComment(requestBody).compose(RxUtils.<HttpResponse<UserListCommentBean>>rxScheduleThread())
                .compose(RxUtils.<UserListCommentBean>handeResult())
                .subscribe(new BaseObserver<UserListCommentBean>(listCommentCallBak) {
                    @Override
                    public void onNext(UserListCommentBean value) {
                        listCommentCallBak.setListCommentTab(value);
                    }
                });
    }
}
