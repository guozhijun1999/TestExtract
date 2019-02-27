package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/18.
 */

public interface TagsHot {
    interface TagsHotV extends BaseView {
        void showTagsHotTab(TagsHotBean tagsHotBean);
        void showTagsHotSearchTab(TagsSearchBean tagsSearchBean);
        void showError(String error);
    }

    interface TagsHotP{
        void getTagsHotTab();
        void getTagsHotSearchTab(String keyword, String cursor);
    }

     interface TagsHotCallBak extends HttpFinishCallbak{
        void setTagsHotTab(TagsHotBean tagsHotTab);
         void setTagsSearchTab(TagsSearchBean tagsSearchTab);
    }
}
