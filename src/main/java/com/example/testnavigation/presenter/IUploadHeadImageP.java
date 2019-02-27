package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.inform.UploadHeadImage;
import com.example.testnavigation.contact.IUploadHeadImage;
import com.example.testnavigation.moudle.IUploadHeadImageM;

import java.io.File;

public class IUploadHeadImageP<V extends IUploadHeadImage.UploadHeadImageV> extends BasePresenter<V> implements IUploadHeadImage.UploadHeadImageP,IUploadHeadImage.UploadHeadImageCallBak{
    private IUploadHeadImageM mImageM=new IUploadHeadImageM();


    @Override
    public void getLisIcon(File fileName) {
        if (mMView!=null){
            mImageM.getIUploadHeadImage(fileName,this);
        }
    }

    @Override
    public void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex) {
        if (mMView!=null){
            mImageM.getUpdateInfo(userId,birthday,nickname,personalProfile,professionId,sex,this);
        }
    }

    @Override
    public void setListIcon(UploadHeadImage uploadHeadImage) {
        if (mMView!=null){
            mMView.showListIcon(uploadHeadImage);
        }
    }

    @Override
    public void setUpdateInfo() {
        if (mMView!=null){
            mMView.showUpdateInfo();
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
