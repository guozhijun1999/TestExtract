package com.example.testnavigation.brean.topic;

import java.util.List;

/**
 * Created by 88888 on 2019/1/28.
 */

public class TopicDetailsBean {

    /**
     * comments : 72
     * headImagePath : http://39.107.254.232/firstga/images/head/2018-12-20/9f6f3213b02244439d8d119e49aee364_1545294239726.png
     * imageListThumb : ["http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628617269.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628617765.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618037.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618333.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618489.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618631.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618774.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628618926.jpg","http://39.107.254.232/firstga/images/topic/2018-05-18/9f6f3213b02244439d8d119e49aee364_1526628619311.jpg"]
     * isFavoured : 0
     * isFollowed : 0
     * isLiked : 1
     * likes : 12
     * nickname : null
     * publishTime : 2018-05-29
     * shareLink :
     * title : 川航客机的风挡玻璃为何会破裂？--多图了解
     * topicId : dc2f506394704e15a2a79e402707930a
     * userId : 9f6f3213b02244439d8d119e49aee364
     */

    private int comments;
    private String headImagePath;
    private int isFavoured;
    private int isFollowed;
    private int isLiked;
    private int likes;
    private String nickname;
    private String publishTime;
    private String shareLink;
    private String title;
    private String topicId;
    private String userId;
    private List<String> imageListThumb;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public int getIsFavoured() {
        return isFavoured;
    }

    public void setIsFavoured(int isFavoured) {
        this.isFavoured = isFavoured;
    }

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getImageListThumb() {
        return imageListThumb;
    }

    public void setImageListThumb(List<String> imageListThumb) {
        this.imageListThumb = imageListThumb;
    }
}
