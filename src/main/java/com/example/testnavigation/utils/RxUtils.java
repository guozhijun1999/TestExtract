package com.example.testnavigation.utils;

import com.example.testnavigation.http.ApiException;
import com.example.testnavigation.http.HttpResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {
    public static <T>ObservableTransformer<T,T>rxScheduleThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public static <T>ObservableTransformer<HttpResponse<T>,T>handeResult(){
        return new ObservableTransformer<HttpResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<HttpResponse<T>> upstream) {
                return upstream.flatMap(new Function<HttpResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(HttpResponse<T> tHttpResponse) throws Exception {
                        if (tHttpResponse.getCode()==0){
                            return createData(tHttpResponse.getData());
                        }else {

                            return Observable.error(new ApiException(tHttpResponse.getCode(),tHttpResponse.getMessage()));
                        }
                    }
                });
            }
        };
    }

    private static <T> ObservableSource<T> createData(final T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitte) throws Exception {
                try {
                    emitte.onNext(data);
                    emitte.onComplete();
                }catch (Exception e){
                    emitte.onError(e);
                }
            }
        });
    }
}
