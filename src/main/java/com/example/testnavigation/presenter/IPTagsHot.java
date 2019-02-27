package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.TagsHot;
import com.example.testnavigation.moudle.IMTagsHot;

public class IPTagsHot<V extends TagsHot.TagsHotV> extends BasePresenter<V> implements TagsHot.TagsHotP ,TagsHot.TagsHotCallBak {
    private IMTagsHot mIMTagsHot=new IMTagsHot();
    @Override
    public void getTagsHotTab() {
        if (mMView!=null){
            mIMTagsHot.getTagsHot(this);
        }
    }

    @Override
    public void getTagsHotSearchTab(String keyword, String cursor) {
        if (mMView!=null){
            mIMTagsHot.getTagSearch(keyword,cursor,this);
        }
    }

    @Override
    public void setTagsHotTab(TagsHotBean tagsHotTab) {
        if (mMView!=null){
            mMView.showTagsHotTab(tagsHotTab);
        }
    }

    @Override
    public void setTagsSearchTab(TagsSearchBean tagsSearchTab) {
        if (mMView!=null){
            mMView.showTagsHotSearchTab(tagsSearchTab);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
