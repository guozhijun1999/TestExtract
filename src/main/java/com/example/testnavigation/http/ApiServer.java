package com.example.testnavigation.http;

import com.example.testnavigation.brean.inform.DownListNews;
import com.example.testnavigation.brean.inform.HotBean;
import com.example.testnavigation.brean.inform.InfoBean;
import com.example.testnavigation.brean.inform.ListNewsChannel;
import com.example.testnavigation.brean.inform.SearchBean;
import com.example.testnavigation.brean.inform.SearchTopicBean;
import com.example.testnavigation.brean.inform.UpListNews;
import com.example.testnavigation.brean.inform.UploadHeadImage;
import com.example.testnavigation.brean.mine.FastLoginBean;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;
import com.example.testnavigation.brean.mine.FavouriteTopicBean;
import com.example.testnavigation.brean.mine.ListFollowBean;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.brean.mine.ListTopicBean;
import com.example.testnavigation.brean.mine.MoreFollowBean;
import com.example.testnavigation.brean.mine.UserInfoBean;
import com.example.testnavigation.brean.mine.UserListCommentBean;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.example.testnavigation.brean.topic.SousuoinfoBean;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.brean.topic.TopicDetailsBean;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

public interface ApiServer {

//    @POST("news/listNewsChannel")
//    @Headers("Content-Type:application/x-www-form-urlencoded")
//    Observable<HttpResponse<ListNewsChannel>> getListNewsChannel(@Body RequestBody requestBody);
    //新闻频道
    @POST
    Observable<HttpResponse<ListNewsChannel>> getPost(@Url String url, @Body RequestBody requestBody, @Header("Content-Type") String head);

    @POST
    @Multipart
    Observable<String> getFile(@Url String url, @Part MultipartBody.Part part, @PartMap Map<String,RequestBody> map);

    //上传头像
    @POST("users/uploadHeadImage")
    @Headers("Content-Type:multipart/form-data")
    Observable<HttpResponse<UploadHeadImage>> setUserImage(@Body RequestBody body);

    @POST
    Observable<HttpResponse<UpListNews>> getNewsList(@Url String url, @Body RequestBody requestBody, @Header("Content-Type") String head);

    //加载新闻列表
    @POST
    Observable<HttpResponse<DownListNews>> getNewsDetails(@Url String url, @Body RequestBody requestBody, @Header("Content-Type") String head);

    //新闻详情
    @POST("news/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<InfoBean>> getInfo(@Body RequestBody requestBody);

    //热门搜索
    @POST("search/hot")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HotBean> getHot(@Body RequestBody body);

    //搜索新闻
    @POST("news/search")
    @Headers("Content-Type:application/json")
    Observable<SearchBean> getSearchNews(@Body RequestBody body);

    //搜索话题
    @POST("topic/search")
    @Headers("Content-Type:application/json")
    Observable<SearchTopicBean> getSearchTopic(@Body RequestBody body);

    //搜索详情
    @POST("topic/search")
    @Headers("Content-Type:application/json")
    Observable<SousuoinfoBean> getsousuoinfo(@Body RequestBody body);

    //加载话题列表
    @POST("topic/loadTopic")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse<LoadTopicBean>> getLoadTopic(@Body RequestBody requestBody);

    //话题详情
    @POST("topic/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<TopicDetailsBean>> getTopicinfo(@Body RequestBody requestBody);

    //评论列表
    @POST("comment/listComment")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse<ListCommentBean>> getListComment(@Body RequestBody requestBody);

    //用户评论新闻|话题
    @POST("users/comment")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse> getUserComment(@Body RequestBody requestBody);

    //发布话题
    @POST("topic/insertTopic")
    @Multipart
    Observable<HttpResponse> getinsertTopic(@Part List<MultipartBody.Part> list);

    //5.4热门标签
    @POST("tags/hot")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<TagsHotBean> getTagsHot(@Body RequestBody requestBody);

    //5.1标签搜索
    @POST("tags/search")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse<TagsSearchBean>> getTagsSearch(@Body RequestBody requestBody);


    //快速登录
    @POST("users/fastLogin")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse<FastLoginBean>> getFastLogin(@Body RequestBody requestBody);

    //1.11设置-个人设置
    @POST("users/info")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<UserInfoBean>> getUserInfo(@Body RequestBody requestBody);

    //设置-修改个人信息
    @POST("users/updateInfo")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse> getupdateInfo(@Body RequestBody requestBody);

    //收藏-新闻列表
    @POST("users/favourite/news")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<FavouriteNewsBean>> getFavouriteNews(@Body RequestBody requestBody);

    //收藏-话题列表
    @POST("users/favourite/topic")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<FavouriteTopicBean>> getFavouriteTopic(@Body RequestBody requestBody);

    //评论-评论列表
    @POST("users/listComment")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<UserListCommentBean>> getUserListComment(@Body RequestBody requestBody);

    //关注-我的关注列表
    @POST("users/listFollow")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<ListFollowBean>> getListFollow(@Body RequestBody requestBody);

    //消息通知-消息列表
    @POST("users/listNotify")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<ListNotifyBean> getListNotify(@Body RequestBody requestBody);

    //关注-更多关注-关注列表
    @POST("users/moreFollow")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse<MoreFollowBean>>getMoreFollow(@Body RequestBody requestBody);

    //我的话题
    @POST("users/listTopic")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<HttpResponse<ListTopicBean>> getListTopic(@Body RequestBody requestBody);

    //点赞
    @POST("users/like")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse> getLike(@Body RequestBody requestBody);

    //关注
    @POST("users/follow")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse> getFollow(@Body RequestBody requestBody);

    //点击收藏
    @POST("users/favourite")
    @Headers("Content-Type:application/json")
    Observable<HttpResponse> getFavourite(@Body RequestBody requestBody);
}
