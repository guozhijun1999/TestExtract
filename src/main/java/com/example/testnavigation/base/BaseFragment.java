package com.example.testnavigation.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

public abstract class BaseFragment<V,P extends BasePresenter<V>> extends SimpleFragment {

    public P mPresenter;
    public ZLoadingDialog mZLoadingDialog;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = createPresemter();
        if (mPresenter!=null){
            mPresenter.attachView((V)this);
        }
        load();
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract P createPresemter();

    @Override
    public void createProgressBar() {
        super.createProgressBar();
        mZLoadingDialog = new ZLoadingDialog(mActivity);
        mZLoadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)//设置类型
                .setLoadingColor(Color.BLACK)//颜色
                .setHintText("Loading...");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(mPresenter!=null){
                load();
            }
        }
    }

    public void load() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.destoryView();
            mPresenter=null;
        }

        super.onDestroyView();
    }
}
