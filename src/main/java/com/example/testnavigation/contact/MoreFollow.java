package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.MoreFollowBean;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/18.
 */

public interface MoreFollow {
    interface MoreFollowV extends BaseView {
        void showTagsHotTab(TagsHotBean tagsHotBean);
        void showMoreFollowTab(MoreFollowBean moreFollowBean);
        void showFollow();
        void showTagsHotSearchTab(TagsSearchBean tagsSearchBean);
        void showError(String error);
    }

    interface MoreFollowP{
        void getTagsHotTab();
        void getMoreFollowTab(String userId, String tagId, String cursor);
        void getFollow(String userId, String followUid, String type);
        void getTagsHotSearchTab(String keyword, String cursor);
    }

     interface MoreFollowCallBak extends HttpFinishCallbak{
        void setTagsHotTab(TagsHotBean tagsHotTab);
         void setMoreFollowTab(MoreFollowBean moreFollowBean);
         void setFollow();
         void setTagsSearchTab(TagsSearchBean tagsSearchTab);
    }
}
