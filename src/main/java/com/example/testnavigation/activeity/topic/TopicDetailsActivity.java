package com.example.testnavigation.activeity.topic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.adapter.topic.ListCommentAdapter;
import com.example.testnavigation.adapter.topic.TopicInfoAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.brean.topic.TopicDetailsBean;
import com.example.testnavigation.contact.TopicInfo;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPTopicInfo;
import com.example.testnavigation.utils.ShareUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopicDetailsActivity extends BaseActivity<TopicInfo.TopicInfoV, IPTopicInfo<TopicInfo.TopicInfoV>> implements TopicInfo.TopicInfoV, XRecyclerView.LoadingListener {

    @BindView(R.id.topic_detail_toolbar_opions)
    ImageView topicDetailToolbarOpions;
    @BindView(R.id.topic_detail_toolbar)
    Toolbar topicDetailToolbar;
    @BindView(R.id.topic_detail_headimg)
    ImageView topicDetailHeadimg;
    @BindView(R.id.topic_detail_headname)
    TextView topicDetailHeadname;
    @BindView(R.id.topic_detail_time)
    TextView topicDetailTime;
    @BindView(R.id.topic_detail_attention_tv)
    TextView topicDetailAttentionTv;
    @BindView(R.id.topic_detail_attention)
    LinearLayout topicDetailAttention;
    @BindView(R.id.topic_detail_title)
    TextView topicDetailTitle;
    @BindView(R.id.topic_detail_images)
    LinearLayout topicDetailImages;
    @BindView(R.id.topic_detail_good_number)
    TextView topicDetailGoodNumber;
    @BindView(R.id.topic_detail_good)
    RelativeLayout topicDetailGood;
    @BindView(R.id.topic_drtail_hotcomment)
    TextView topicDrtailHotcomment;
    @BindView(R.id.topic_detail_comment_list)
    CardView topicDetailCommentList;
    @BindView(R.id.topic_detail_rv)
    XRecyclerView topicDetailRv;
    @BindView(R.id.topic_detail_img_share)
    ImageView topicDetailImgShare;
    @BindView(R.id.topic_detail_text_share)
    TextView topicDetailTextShare;
    @BindView(R.id.topic_detail_share_linear)
    LinearLayout topicDetailShareLinear;
    @BindView(R.id.topic_detail_img_comment)
    ImageView topicDetailImgComment;
    @BindView(R.id.topic_detail_text_comment)
    TextView topicDetailTextComment;
    @BindView(R.id.topic_detail_comment_linear)
    LinearLayout topicDetailCommentLinear;
    @BindView(R.id.topic_detail_img_collect)
    ImageView topicDetailImgCollect;
    @BindView(R.id.topic_detail_text_collect)
    TextView topicDetailTextCollect;
    @BindView(R.id.topic_detail_collect_linear)
    LinearLayout topicDetailCollectLinear;
    @BindView(R.id.topic_detail_linear)
    LinearLayout topicDetailLinear;
    @BindView(R.id.topic_detail_layout)
    RelativeLayout topicDetailLayout;
    @BindView(R.id.jingxuaninforecycler)
    RecyclerView mJingxuaninforecycler;
    private String mTopicId;
    private String mCursor;
    private List<ListCommentBean.CommentListBean> mListBeans = new ArrayList<>();
    private ListCommentAdapter mListCommentAdapter;
    private List<TopicDetailsBean> mTopicDetailsBeans = new ArrayList<>();
    private TopicInfoAdapter mTopicInfoAdapter;
    private List<String> mList = new ArrayList<>();
    private String mUserId;
    private SharedPreferences mSh;
    private SharedPreferences.Editor mEd;
    private int mLikes;
    private int a = 1;
    private boolean cang=false;
    @Override
    protected void initEventAndData() {
        //创建一个sp用于存储是否关注
        mSh = getSharedPreferences("xx", MODE_PRIVATE);
        mEd = mSh.edit();

        if (!mSh.getBoolean("type", false)) {
            topicDetailAttentionTv.setText("关注");

        } else {
            topicDetailAttentionTv.setText("已关注");
        }
        if (mSh.getInt("like", 1) == 1) {
            topicDetailGoodNumber.setText(mLikes + "");
        } else {
            topicDetailGoodNumber.setText(mLikes + "");
        }

        if (!mSh.getBoolean("cang",false)){
            topicDetailImgCollect.setImageResource(R.mipmap.detail_img_collect);
        }else {
            topicDetailImgCollect.setImageResource(R.mipmap.detail_image_collects);
        }

        topicDetailToolbar.setTitle("");
        setSupportActionBar(topicDetailToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        mTopicId = intent.getStringExtra("topicId");
        mPresenter.getTopicInfoTab(mTopicId, Global.USERID);
        mJingxuaninforecycler.setLayoutManager(new GridLayoutManager(this, 3));
        mTopicInfoAdapter = new TopicInfoAdapter(mActivity, mList);
        mJingxuaninforecycler.setAdapter(mTopicInfoAdapter);
//        mJingxuaninforecycler.setLayoutManager(new LinearLayoutManager(this));

        mPresenter.getListComment(mTopicId, "1", "0");

        LinearLayoutManager manager = new LinearLayoutManager(this);
        topicDetailRv.setLayoutManager(manager);
        mListCommentAdapter = new ListCommentAdapter(mActivity, mListBeans);
        topicDetailRv.setAdapter(mListCommentAdapter);
        topicDetailRv.setLoadingListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int createLayoutId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
//设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置系统状态栏的颜色
            window.setStatusBarColor(getResources().getColor(R.color.home_toolbar_bgcolor));
        }
        return R.layout.activity_topic_details;
    }

    @Override
    protected IPTopicInfo<TopicInfo.TopicInfoV> createdPresenter() {
        return new IPTopicInfo<>();
    }

    @Override
    public void showTopicInfoTab(TopicDetailsBean topicDetailsBean) {
//        mTopicDetailsBeans.add(topicDetailsBean);
        mUserId = topicDetailsBean.getUserId();
        mLikes = topicDetailsBean.getLikes();
        for (int i = 0; i < topicDetailsBean.getImageListThumb().size(); i++) {
            mList.add(topicDetailsBean.getImageListThumb().get(i));
        }
        mTopicInfoAdapter.notifyDataSetChanged();
        Glide.with(this).load(topicDetailsBean.getHeadImagePath()).into(topicDetailHeadimg);
        topicDetailTitle.setText(topicDetailsBean.getTitle());
        topicDetailHeadname.setText(topicDetailsBean.getNickname());
        topicDetailTime.setText(topicDetailsBean.getPublishTime());
//        Glide.with(this).load(topicDetailsBean.getImageListThumb().get(0)).into(topicDetailImage1);
        topicDetailGoodNumber.setText(topicDetailsBean.getLikes());
        topicDrtailHotcomment.setText("热门评论" + topicDetailsBean.getComments() + "0" + "条");
    }

    @Override
    public void showListCommentTab(ListCommentBean listCommentBean) {
        mCursor = listCommentBean.getCursor();
        mListCommentAdapter.addData(listCommentBean.getCommentList());
        topicDetailRv.loadMoreComplete();
    }

    @Override
    public void showUserComment() {

    }

    @Override
    public void showLike() {

    }

    @Override
    public void showFollow() {

    }

    @Override
    public void showFavourite() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onRefresh() {
        mPresenter.getListComment(mTopicId, "1", "0");
        topicDetailRv.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        if (mCursor != null) {
            mPresenter.getListComment(mTopicId, "1", mCursor);
        }
    }

    @OnClick({R.id.topic_detail_collect_linear,R.id.topic_detail_toolbar_opions, R.id.topic_detail_attention_tv, R.id.topic_detail_img_share, R.id.topic_detail_text_comment, R.id.topic_detail_text_collect, R.id.topic_detail_good})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.topic_detail_toolbar_opions:
                ShareUtil.shareText(TopicDetailsActivity.this, mTopicId, "分享一篇文章");
                Toast.makeText(this, "已分享标题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.topic_detail_attention_tv:
                if (mSh.getBoolean("type", false) == false) {
                    topicDetailAttentionTv.setText("已关注");
                    mPresenter.getFollow(Global.USERID, mUserId, "0");
                    mEd.putBoolean("type", true);
                } else {
                    topicDetailAttentionTv.setText("关注");
                    mPresenter.getFollow(Global.USERID, mUserId, "1");
                    mEd.putBoolean("type", false);
                }
                mEd.commit();

                break;
            case R.id.topic_detail_img_share:
                ShareUtil.shareText(TopicDetailsActivity.this, mTopicId, "分享一篇文章");
                Toast.makeText(this, "已分享标题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.topic_detail_text_comment:
                showpop();
                break;
            case R.id.topic_detail_text_collect:
                break;
            case R.id.topic_detail_good:
                if (mSh.getInt("like", 1) == 1) {
                    mLikes++;
                    topicDetailGoodNumber.setText(mLikes + "");
                    SharedPreferences.Editor like = mEd.putInt("like", 0);
                    mPresenter.getLike(Global.USERID, mUserId, "1", mSh.getInt("like", 0) + "");
                    Toast.makeText(TopicDetailsActivity.this, "赞！！！", Toast.LENGTH_SHORT).show();
                } else {
                    if (mLikes >= 1) {
                        mLikes--;
                        topicDetailGoodNumber.setText(mLikes + "");
                    }
                    SharedPreferences.Editor like = mEd.putInt("like", 1);
                    mPresenter.getLike(Global.USERID, mUserId, "1", mSh.getInt("like", 1) + "");
                    Toast.makeText(TopicDetailsActivity.this, "取消赞", Toast.LENGTH_SHORT).show();
                }
                mEd.commit();
                break;
            case R.id.topic_detail_collect_linear:
                if (mSh.getBoolean("cang", false) == false){
                    topicDetailImgCollect.setImageResource(R.mipmap.detail_image_collects);
                    mPresenter.getFavourite(Global.USERID, mUserId, "1", 0 + "");
                    Toast.makeText(TopicDetailsActivity.this, "收藏了", Toast.LENGTH_SHORT).show();
                    mEd.putBoolean("cang",true);
                }else {
                    topicDetailImgCollect.setImageResource(R.mipmap.detail_img_collect);
                    mPresenter.getFavourite(Global.USERID, mUserId, "1", 1 + "");
                    Toast.makeText(TopicDetailsActivity.this, "取消收藏了", Toast.LENGTH_SHORT).show();
                    mEd.putBoolean("cang",false);
                }
                mEd.commit();
//                if (cang == false){
//                    cang=true;
//                    topicDetailImgCollect.setImageResource(R.mipmap.detail_image_collects);
//                    mPresenter.getFavourite(Global.USERID, mUserId, "1", 0+"");
//                    Toast.makeText(TopicDetailsActivity.this,"收藏了",Toast.LENGTH_SHORT).show();
//                }else {
//                    cang=false;
//                    topicDetailImgCollect.setImageResource(R.mipmap.detail_img_collect);
//                    mPresenter.getFavourite(Global.USERID, mUserId, "1", 1+"");
//                    Toast.makeText(TopicDetailsActivity.this,"取消收藏了",Toast.LENGTH_SHORT).show();
//                }
                break;
        }
    }

    @SuppressLint("WrongConstant")
    private void showpop() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_detail_comment, null);
        final PopupWindow pop = new PopupWindow(this);
        pop.setContentView(view);
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        pop.setAnimationStyle(R.style.pop);
        pop.setFocusable(true);
        pop.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        //防止PopupWindow被软件盘挡住
        pop.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        final InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //这里给它设置了弹出的时间，
        imm.toggleSoftInput(1000, InputMethodManager.HIDE_NOT_ALWAYS);

        TextView cancel = view.findViewById(R.id.detail_comment_cancel);
        TextView release = view.findViewById(R.id.detail_comment_release);
        final EditText comment = view.findViewById(R.id.detail_comment_edi);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

        release.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getUserComment(Global.USERID, mTopicId, "0", comment.getText().toString());
                pop.dismiss();
            }
        });
    }

    @OnClick(R.id.topic_detail_collect_linear)
    public void onViewClicked() {
    }
}
