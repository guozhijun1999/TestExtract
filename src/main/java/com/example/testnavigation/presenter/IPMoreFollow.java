package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.MoreFollowBean;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.MoreFollow;
import com.example.testnavigation.moudle.IMMoreFollow;

public class IPMoreFollow<V extends MoreFollow.MoreFollowV> extends BasePresenter<V> implements MoreFollow.MoreFollowP , MoreFollow.MoreFollowCallBak{
    private IMMoreFollow mIMMoreFollow=new IMMoreFollow();
    @Override
    public void getTagsHotTab() {
        if (mMView!=null){
            mIMMoreFollow.geTagsHot(this);
        }
    }

    @Override
    public void getMoreFollowTab(String userId, String tagId, String cursor) {
        if (mMView!=null){
            mIMMoreFollow.getMoreFollow(userId,tagId,cursor,this);
        }
    }

    @Override
    public void getFollow(String userId, String followUid, String type) {
        if (mMView!=null){
            mIMMoreFollow.getFollow(userId,followUid,type,this);
        }
    }

    @Override
    public void getTagsHotSearchTab(String keyword, String cursor) {
        if (mMView!=null){
            mIMMoreFollow.getTagSearch(keyword,cursor,this);
        }
    }

    @Override
    public void setTagsHotTab(TagsHotBean tagsHotTab) {
        if (mMView!=null){
            mMView.showTagsHotTab(tagsHotTab);
        }
    }

    @Override
    public void setMoreFollowTab(MoreFollowBean moreFollowBean) {
        if (mMView!=null){
            mMView.showMoreFollowTab(moreFollowBean);
        }
    }

    @Override
    public void setFollow() {
        if (mMView!=null){
            mMView.showFollow();
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
