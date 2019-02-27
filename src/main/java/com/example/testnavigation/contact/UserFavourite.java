package com.example.testnavigation.contact;

import com.example.testnavigation.base.BaseView;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;
import com.example.testnavigation.brean.mine.FavouriteTopicBean;
import com.example.testnavigation.http.HttpFinishCallbak;

/**
 * Created by 88888 on 2019/1/22.
 */

public interface UserFavourite {
    interface UserFavouriteV extends BaseView {
        void showUserFavouriteNewsTab(FavouriteNewsBean favouriteNewsBean);
        void showUserFavouriteTopicTab(FavouriteTopicBean favouriteTopicBean);
        void showError(String error);
    }

    interface UserFavouriteP{
        void getUserFavouriteNewsTab(String userId, String cursor);
        void getUserFavouriteTopicTab(String userId, String cursor);
    }

    interface UserFavouriteCallBak extends HttpFinishCallbak {
        void setUserFavouriteNewsTab(FavouriteNewsBean favouriteNewsBean);
        void setUserFavouriteTopicTab(FavouriteTopicBean favouriteTopicBean);
    }
}
