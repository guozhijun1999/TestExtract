package com.example.testnavigation.base;

import android.graphics.Color;

import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity   {


    public P mPresenter;
    public ZLoadingDialog mZLoadingDialog;

    @Override
    protected void viewCreated() {
        mPresenter = createdPresenter();
        if (mPresenter!=null){
            mPresenter.attachView((V)this);
        }

    }

    @Override
    public void createProgressBar() {
        super.createProgressBar();
        mZLoadingDialog = new ZLoadingDialog(this);
        mZLoadingDialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)//设置类型
                .setLoadingColor(Color.BLACK)//颜色
                .setHintText("Loading...");
    }

    protected abstract P createdPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.destoryView();
            mPresenter=null;
        }
    }

}
