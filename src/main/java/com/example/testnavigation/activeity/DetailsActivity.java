package com.example.testnavigation.activeity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.topic.ListCommentAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.inform.InfoBean;
import com.example.testnavigation.brean.topic.ListCommentBean;
import com.example.testnavigation.contact.NewsInfo;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPNewsInfo;
import com.example.testnavigation.utils.ShareUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity<NewsInfo.NewsInfoV, IPNewsInfo<NewsInfo.NewsInfoV>> implements NewsInfo.NewsInfoV, XRecyclerView.LoadingListener {

    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_source)
    TextView tvSource;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    @BindView(R.id.wv)
    WebView wv;
    @BindView(R.id.iv_major)
    ImageView ivMajor;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.rlv_similarity)
    RecyclerView rlvSimilarity;
    @BindView(R.id.rlv_follow)
    XRecyclerView rlvFollow;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.iv_reply)
    ImageView ivReply;
    @BindView(R.id.iv_huifu)
    ImageView ivHuifu;
    @BindView(R.id.iv_newsLike)
    ImageView ivNewsLike;
    @BindView(R.id.iv_forward)
    ImageView ivForward;
    private String mTitle;
    private String mTopicId;
    private String mCursor;
    private List<ListCommentBean.CommentListBean> mListBeans = new ArrayList<>();
    private ListCommentAdapter mListCommentAdapter;
    private String mNewId;
    private int like = 1;
    private int cang = 1;
    private SharedPreferences mSh;
    private SharedPreferences.Editor mEd;

    @Override
    protected void initEventAndData() {
        mSh = getSharedPreferences("shoucang", MODE_PRIVATE);
        mEd = mSh.edit();

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);



        Intent intent = getIntent();
        mNewId = intent.getStringExtra("newId");

        if (mNewId != null) {
            mPresenter.getNewsInfoTab(mNewId);
        }

        Intent intent1 = getIntent();
        mTopicId = intent1.getStringExtra("topicId");

        mPresenter.getListComment(mNewId, "0", "0");

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rlvFollow.setLayoutManager(manager);
        mListCommentAdapter = new ListCommentAdapter(mActivity, mListBeans);
        rlvFollow.setAdapter(mListCommentAdapter);
        rlvFollow.setLoadingListener(this);
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
        return R.layout.activity_details;
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
    protected IPNewsInfo<NewsInfo.NewsInfoV> createdPresenter() {
        return new IPNewsInfo<>();
    }

    @Override
    public void showNewsInfoTab(InfoBean info) {
        mTitle = info.getTitle();
        //设置数据
        tvTitle.setText(info.getTitle());
        tvTime.setText(info.getPublishTime());

        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        wv.loadUrl(info.getContent());

        String newContent = getNewContent(info.getContent());
        wv.loadDataWithBaseURL(null, newContent, "text/html", "utf-8", null);
        wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);


    }

    @Override
    public void showListCommentTab(ListCommentBean listCommentBean) {
        mCursor = listCommentBean.getCursor();
        mListCommentAdapter.addData(listCommentBean.getCommentList());
        rlvFollow.loadMoreComplete();
    }

    @Override
    public void showUserComment() {

    }

    @Override
    public void showLike() {

    }

    @Override
    public void showFavourite() {

    }

    public static String getNewContent(String htmltext) {
        try {
            Document doc = Jsoup.parse(htmltext);
            Elements elements = doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width", "100%").attr("height", "auto");
            }
            return doc.toString();
        } catch (Exception e) {
            return htmltext;
        }
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

    @OnClick({R.id.iv_share, R.id.iv_collect, R.id.iv_huifu, R.id.iv_newsLike, R.id.iv_forward, R.id.iv_reply, R.id.iv_major})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_share:
                if (mTitle != null) {
                    ShareUtil.shareText(DetailsActivity.this, mTitle, "分享一篇文章");
                    Toast.makeText(this, "已分享标题", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_collect:
                if (mSh.getBoolean("cang",false)==false){
                    mPresenter.getFavourite(Global.USERID, mNewId, "0", "0");
                    Toast.makeText(DetailsActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
                    mEd.putBoolean("cang",true);
                }else {
                    mPresenter.getFavourite(Global.USERID, mNewId, "0", "1");
                    Toast.makeText(DetailsActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();
                    mEd.putBoolean("cang",false);
                }
                mEd.commit();
//                if (cang == 1){
//                    cang = 0;
//                    mPresenter.getFavourite(Global.USERID, mNewId, "0", "0");
//                    Toast.makeText(DetailsActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
//                }else {
//                    cang = 1;
//                    mPresenter.getFavourite(Global.USERID, mNewId, "0", "1");
//                    Toast.makeText(DetailsActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();
//                }


                break;
            case R.id.iv_reply:
                showpop();
                break;
            case R.id.iv_huifu:
                showpop();
                break;
            case R.id.iv_newsLike:
                break;
            case R.id.iv_forward:
                if (mTitle != null) {
                    ShareUtil.shareText(DetailsActivity.this, mTitle, "分享一篇文章");
                    Toast.makeText(this, "已分享标题", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_major:
                if (like == 1) {
                    like = 0;
                    mPresenter.getLike(Global.USERID, mNewId, "0", like + "");
                    Toast.makeText(DetailsActivity.this, "赞！！！", Toast.LENGTH_SHORT).show();
                } else {
                    like = 1;
                    mPresenter.getLike(Global.USERID, mNewId, "0", like + "");
                    Toast.makeText(DetailsActivity.this, "取消赞", Toast.LENGTH_SHORT).show();
                }
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
                mPresenter.getUserComment(Global.USERID, mNewId, "0", comment.getText().toString());
                pop.dismiss();
            }
        });
    }


    @Override
    public void onRefresh() {
        mPresenter.getListComment(mNewId, "0", "0");
        rlvFollow.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        if (mCursor != null) {
            mPresenter.getListComment(mNewId, "0", mCursor);
        }
    }

}
