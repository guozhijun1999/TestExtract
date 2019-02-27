package com.example.testnavigation.activeity.mine;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.mine.ArtcleAdapter;
import com.example.testnavigation.adapter.mine.Topicadapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;
import com.example.testnavigation.brean.mine.FavouriteTopicBean;
import com.example.testnavigation.contact.UserFavourite;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserFavourite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends BaseActivity<UserFavourite.UserFavouriteV, IPUserFavourite<UserFavourite.UserFavouriteV>> implements UserFavourite.UserFavouriteV {

    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.article)
    TextView mArticle;
    @BindView(R.id.topic)
    TextView mTopic;
    @BindView(R.id.cancel)
    TextView mCancel;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.rv_article)
    RecyclerView mRvArticle;
    @BindView(R.id.rv_topic)
    RecyclerView mRvTopic;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.delect)
    LinearLayout mDelect;
    public static int biaoji = 0;
    private ArtcleAdapter mArtcleAdapter;
    private Topicadapter mTopicadapter;
    private boolean isgai = false;
    int count = 0;
    public Map<Integer, Boolean> map = new HashMap<>();
    private TextView ok;
    private TextView ko;
    private PopupWindow popupWindow;
    private List<FavouriteNewsBean.FavouritNewsListBean> mFavouritNewsList;

    @Override
    protected void initEventAndData() {
        mPresenter.getUserFavouriteNewsTab(Global.USERID, "0");
        mPresenter.getUserFavouriteTopicTab(Global.USERID, "0");
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
        return R.layout.activity_collect;
    }

    @Override
    protected IPUserFavourite<UserFavourite.UserFavouriteV> createdPresenter() {
        return new IPUserFavourite<>();
    }

    @Override
    public void showUserFavouriteNewsTab(FavouriteNewsBean favouriteNewsBean) {
        mFavouritNewsList = favouriteNewsBean.getFavouritNewsList();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRvArticle.setLayoutManager(manager);
        mRvArticle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mArtcleAdapter = new ArtcleAdapter(mActivity, favouriteNewsBean.getFavouritNewsList(), map);
        mRvArticle.setAdapter(mArtcleAdapter);
        for (int i = 0; i < mFavouritNewsList.size(); i++) {
            map.put(i, false);
        }
        mArtcleAdapter.setOnItmeClickArtcle(new ArtcleAdapter.OnItmeClickArtcle() {
            @Override
            public void onDianji(int position, ArtcleAdapter.ViewHolder viewHolder) {
                if (!map.get(position)) {
                    viewHolder.mSelect.setImageResource(R.mipmap.collect_select);
                    map.put(position, true);
                } else {
                    viewHolder.mSelect.setImageResource(R.mipmap.collect_selects);
                    map.put(position, false);
                }

                for (int j = 0; j < map.size(); j++) {
                    if (map.get(j)) {
                        count++;
                    }
                }
                mTv.setText("删除" + "(" + count + ")");
                count = 0;
            }
        });
    }

    @Override
    public void showUserFavouriteTopicTab(FavouriteTopicBean favouriteTopicBean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRvTopic.setLayoutManager(manager);
        mTopicadapter = new Topicadapter(mActivity, favouriteTopicBean.getFavouritTopicList());
        mRvTopic.setAdapter(mTopicadapter);
        mTopicadapter.notifyDataSetChanged();
        Log.e("8465151561564", favouriteTopicBean.getFavouritTopicList().toString());
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

    @OnClick({R.id.iv, R.id.article, R.id.topic, R.id.cancel,R.id.tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                finish();
                break;
            case R.id.article:
                mTopic.setBackgroundResource(R.color.colorRed);
                mArticle.setBackgroundResource(R.color.ba);
                mRvArticle.setVisibility(View.VISIBLE);
                mRvTopic.setVisibility(View.GONE);
                mCancel.setVisibility(View.VISIBLE);
                mDelect.setVisibility(View.VISIBLE);
                break;
            case R.id.topic:
                mTopic.setBackgroundResource(R.color.ba);
                mArticle.setBackgroundResource(R.color.colorRed);
                mRvArticle.setVisibility(View.GONE);
                mRvTopic.setVisibility(View.VISIBLE);
                mCancel.setVisibility(View.GONE);
                mDelect.setVisibility(View.GONE);
                break;
            case R.id.cancel:
                if (mCancel.getText().equals("编辑")) {
                    biaoji = 1;
                    mCancel.setText("完成");
                    mDelect.setVisibility(View.VISIBLE);
                    mArtcleAdapter.notifyDataSetChanged();
                } else {
                    biaoji = 0;
                    mCancel.setText("编辑");
                    mDelect.setVisibility(View.GONE);
                    mArtcleAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.tv:
                int count = 0;
                for (int i = 0; i < mFavouritNewsList.size(); i++) {
                    if (map.get(count)) {
                        mFavouritNewsList.remove(i);
                        map.remove(count);
                        count++;
                        i--;
                    } else {
                        count++;
                    }
                }

                map.clear();
                for (int i = 0; i < mFavouritNewsList.size(); i++) {
                    map.put(i, false);
                }
                mTv.setText("删除(0)");
                mArtcleAdapter.notifyDataSetChanged();
                break;
        }
    }


}
