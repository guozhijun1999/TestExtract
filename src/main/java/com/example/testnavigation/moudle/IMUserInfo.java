package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.UpdateInfo;
import com.example.testnavigation.brean.mine.UserInfoBean;
import com.example.testnavigation.contact.UserInfo;
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

public class IMUserInfo {
    public void getUserInfoList(String userId, final UserInfo.UserInfoCallBak userInfoCallBak){
        RequestBody requestBody=new FormBody.Builder()
                .add("userId",userId)
                .build();
        HttpManager.getInstance().getServer().getUserInfo(requestBody)
                .compose(RxUtils.<HttpResponse<UserInfoBean>>rxScheduleThread())
                .compose(RxUtils.<UserInfoBean>handeResult())
                .subscribe(new BaseObserver<UserInfoBean>(userInfoCallBak) {
                    @Override
                    public void onNext(UserInfoBean value) {
                        userInfoCallBak.setUserInfoTab(value);
                    }
                });
    }

    public void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex, final UserInfo.UserInfoCallBak userInfoCallBak){
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.setUserId(userId);
        updateInfo.setBirthday(birthday);
        updateInfo.setNickname(nickname);
        updateInfo.setPersonalProfile(personalProfile);
        updateInfo.setProfessionId(professionId);
        updateInfo.setSex(sex);
        Gson gson = new Gson();
        String s = gson.toJson(updateInfo);
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getupdateInfo(requestBody)
                .compose(RxUtils.<HttpResponse>rxScheduleThread())
                .flatMap(new Function<HttpResponse, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final HttpResponse httpResponse) throws Exception {
                        if (httpResponse.getCode()!=0){
                            return Observable.error(new ApiException(httpResponse.getCode(),httpResponse.getMessage()));
                        }else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(httpResponse.getMessage());
                                        emm.onComplete();
                                    }catch (Exception el){
                                        emm.onError(el);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(userInfoCallBak) {
            @Override
            public void onNext(String value) {
                userInfoCallBak.setUpdateInfo();
            }
        });
    }
}
