package com.example.testnavigation.base;

import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    private WeakReference<V> weakReference;
    public V mMView;

    public void attachView(V v){
        weakReference=new WeakReference(v);
        if (weakReference!=null){
            mMView = weakReference.get();
        }
    }

    public void destoryView(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }
}
