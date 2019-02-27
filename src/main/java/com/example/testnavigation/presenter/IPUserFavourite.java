package com.example.testnavigation.presenter;

import com.example.testnavigation.base.BasePresenter;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;
import com.example.testnavigation.brean.mine.FavouriteTopicBean;
import com.example.testnavigation.contact.UserFavourite;
import com.example.testnavigation.moudle.IMUserFavourite;

public class IPUserFavourite<V extends UserFavourite.UserFavouriteV> extends BasePresenter<V> implements UserFavourite.UserFavouriteP ,UserFavourite.UserFavouriteCallBak {
    private IMUserFavourite mIMUserFavourite=new IMUserFavourite();
    @Override
    public void getUserFavouriteNewsTab(String userId, String cursor) {
        if (mMView!=null){
            mIMUserFavourite.getUserFavouriteNews(userId,cursor,this);
        }
    }

    @Override
    public void getUserFavouriteTopicTab(String userId, String cursor) {
        if (mMView!=null){
            mIMUserFavourite.getUserFavouriteTopic(userId,cursor,this);
        }
    }

    @Override
    public void setUserFavouriteNewsTab(FavouriteNewsBean favouriteNewsBean) {
        if (mMView!=null){
            mMView.showUserFavouriteNewsTab(favouriteNewsBean);
        }
    }

    @Override
    public void setUserFavouriteTopicTab(FavouriteTopicBean favouriteTopicBean) {
        if (mMView!=null){
            mMView.showUserFavouriteTopicTab(favouriteTopicBean);
        }
    }

    @Override
    public void showError(String error) {
        if (mMView!=null){
            mMView.showError(error);
        }
    }
}
