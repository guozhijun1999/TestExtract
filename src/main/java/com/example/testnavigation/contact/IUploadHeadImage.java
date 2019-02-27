package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.inform.UploadHeadImage;
import com.example.testnavigation.http.HttpFinishCallbak;

import java.io.File;

public interface IUploadHeadImage {
    interface UploadHeadImageV extends BaseView {
        void showListIcon(UploadHeadImage uploadHeadImage);
        void showUpdateInfo();
        void showError(String error);
    }

    interface UploadHeadImageP{
        void getLisIcon(File file);
        void getUpdateInfo(String userId, String birthday, Object nickname, String personalProfile, String professionId, String sex);
    }

    interface UploadHeadImageCallBak extends HttpFinishCallbak {
        void setListIcon(UploadHeadImage uploadHeadImage);
        void setUpdateInfo();
    }
}
