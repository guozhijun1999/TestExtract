package com.example.testnavigation.base;

import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpFinishCallbak;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {
    private HttpFinishCallbak mHttpFinishCallbak;

    public BaseObserver(HttpFinishCallbak httpFinishCallbak) {
        mHttpFinishCallbak = httpFinishCallbak;
    }
    //订阅
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        mCompositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        String error = null;
        //判断是否是我们自定的(服务器返回的错误信息)错误信息
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            switch (apiException.getCode()) {
                case 2001:
                case 2002:
                case 1001:
                    error = "网络错误";
                    break;
                case 2003:
                    error = "非法手机号";
                    break;
                case 2004:
                    error = "验证码一分钟内不能重复发送";
                    break;
                case 2005:
                    error = "短信功能业务限流";
                    break;
                case 2006:
                    error = "验证码发送失败";
                    break;
                case 2100:
                    error = "上传文件为空";
                    break;
                case 2101:
                    error = "文件大小超出限制";
                    break;
                case 2102:
                    error = "非法文件格式";
                    break;
                case 2103:
                    error = "上传文件失败";
                    break;
            }
        } else if (e instanceof HttpException) {
            error = "网络错误";
        }

        if (mHttpFinishCallbak != null) {
            mHttpFinishCallbak.showError(error);
        }
    }

    @Override
    public void onComplete() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
