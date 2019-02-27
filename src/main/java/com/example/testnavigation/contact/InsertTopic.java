package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.http.HttpFinishCallbak;

import java.io.File;
import java.util.List;

/**
 * Created by 88888 on 2019/1/30.
 */

public interface InsertTopic {
    interface InsertTopicV extends BaseView {
        void showInsertTopic();
        void showError(String error);
    }

    interface InsertTopicP{
        void getInsertTopic(String title, List<File> fileList);
    }

    interface InsertTopicCallBak extends HttpFinishCallbak {
        void setInsertTopic();
    }
}
