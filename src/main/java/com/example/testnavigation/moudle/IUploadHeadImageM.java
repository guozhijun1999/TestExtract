package com.example.testnavigation.moudle;


import android.util.Log;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.brean.inform.UpdateInfo;
import com.example.testnavigation.brean.inform.UploadHeadImage;
import com.example.testnavigation.contact.IUploadHeadImage;
import com.example.testnavigation.contact.UserInfo;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.HttpUtils;
import com.example.testnavigation.utils.RxUtils;
import com.google.gson.Gson;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class IUploadHeadImageM {
    public void getIUploadHeadImage(File fileName, final IUploadHeadImage.UploadHeadImageCallBak uploadHeadImageCallBak) {

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("userId", Global.USERID)
                .addFormDataPart("headImageFile", fileName.getName(), RequestBody.create(MediaType.parse("image/jpg"), fileName))
                .build();
        Log.e("1484948",fileName.getPath().toString());
        HttpManager.getInstance().getServer().setUserImage(body)
                .compose(RxUtils.<HttpResponse<UploadHeadImage>>rxScheduleThread())
                .compose(RxUtils.<UploadHeadImage>handeResult())
                .subscribe(new BaseObserver<UploadHeadImage>(uploadHeadImageCallBak) {
                    @Override
                    public void onNext(UploadHeadImage value) {
                        uploadHeadImageCallBak.setListIcon(value);
                        Log.e("51323",value.toString());
                    }
                });
    }

    public void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex, final IUploadHeadImage.UploadHeadImageCallBak uploadHeadImageCallBak) {
        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.setUserId(userId);
        updateInfo.setBirthday(birthday);
        updateInfo.setNickname(nickname);
        updateInfo.setPersonalProfile(personalProfile);
        updateInfo.setProfessionId(professionId);
        updateInfo.setSex(sex);
        Gson gson = new Gson();
        String s = gson.toJson(updateInfo);
        Log.e("9465198451",s.toString());
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json,charset-UTF-8"),s);
        HttpManager.getInstance().getServer().getupdateInfo(requestBody).compose(RxUtils.<HttpResponse>rxScheduleThread())
                .flatMap(new Function<HttpResponse, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final HttpResponse mainBean) throws Exception {
                        if (mainBean.getCode() != 0) {
                            return Observable.error(new ApiException(mainBean.getCode(), mainBean.getMessage()));
                        } else {
                            return Observable.create(new ObservableOnSubscribe<String>() {
                                @Override
                                public void subscribe(ObservableEmitter<String> emm) throws Exception {
                                    try {
                                        emm.onNext(mainBean.getMessage());
                                        emm.onComplete();
                                    } catch (Exception e1) {
                                        emm.onError(e1);
                                    }
                                }
                            });
                        }
                    }
                }).subscribe(new BaseObserver<String>(uploadHeadImageCallBak) {
            @Override
            public void onNext(String value) {
                uploadHeadImageCallBak.setUpdateInfo();

            }
        });
    }
}
