package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.contact.InsertTopic;
import com.example.testnavigation.moudle.IMInsertTopic;

import java.io.File;
import java.util.List;

public class IPInsertTopic<V extends InsertTopic.InsertTopicV> extends BasePresenter<V> implements InsertTopic.InsertTopicP ,InsertTopic.InsertTopicCallBak{
    private IMInsertTopic mInsertTopic = new IMInsertTopic();
    @Override
    public void getInsertTopic(String title, List<File> fileList) {
        if(mMView!=null){
            mInsertTopic.getInsertTopic(title,fileList,this);
        }
    }

    @Override
    public void setInsertTopic() {
        if (mMView!=null){
            mMView.showInsertTopic();
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
