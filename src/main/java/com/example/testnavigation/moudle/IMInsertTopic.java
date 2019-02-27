package com.example.testnavigation.moudle;

import com.example.testnavigation.base.BaseObserver;
import com.example.testnavigation.contact.InsertTopic;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpManager;
import com.example.testnavigation.http.HttpResponse;
import com.example.testnavigation.utils.RxUtils;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class IMInsertTopic {
    public void getInsertTopic(String title, List<File> fileList,final InsertTopic.InsertTopicCallBak insertTopicCallBak) {

//        File file = new File(path);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Builder builder=new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userId", Global.USERID)
                .addFormDataPart("title",title)
                .addFormDataPart("tagList","1")
                .addFormDataPart("shareLink", "http://www.baidu.com");
                //.addFormDataPart("fileList", file.getName(), requestBody)
        for(int i=0;i<(fileList.size()-1);i++){
            RequestBody imagebody=RequestBody.create(MediaType.parse("image/*"),fileList.get(i));
            builder.addFormDataPart("fileList", fileList.get(i).getName(),imagebody);
        }
        List<MultipartBody.Part> list=builder.build().parts();
        HttpManager.getInstance().getServer().getinsertTopic(list).compose(RxUtils.<HttpResponse>rxScheduleThread())
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
                }).subscribe(new BaseObserver<String>(insertTopicCallBak) {
            @Override
            public void onNext(String value) {
                insertTopicCallBak.setInsertTopic();
            }
        });
    }
}
