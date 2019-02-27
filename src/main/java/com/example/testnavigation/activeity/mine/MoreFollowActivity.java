package com.example.testnavigation.activeity.mine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.SousuoInfoactivity;
import com.example.testnavigation.adapter.mine.Moreadapter1;
import com.example.testnavigation.adapter.mine.Moreadapter2;
import com.example.testnavigation.adapter.mine.Moreadapter3;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.mine.MoreFollowBean;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.MoreFollow;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPMoreFollow;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreFollowActivity extends BaseActivity<MoreFollow.MoreFollowV, IPMoreFollow<MoreFollow.MoreFollowV>> implements MoreFollow.MoreFollowV {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.search_edit)
    EditText mSearchEdit;
    @BindView(R.id.search_text_quxiao)
    TextView mSearchTextQuxiao;
    @BindView(R.id.search_toolbar)
    Toolbar mSearchToolbar;
    @BindView(R.id.rlv1)
    RecyclerView mRlv1;
    @BindView(R.id.rlv2)
    RecyclerView mRlv2;
    @BindView(R.id.rlv3)
    RecyclerView mRlv3;
    private Moreadapter2 mMoreadapter2;
    private List<MoreFollowBean.MoreFollowListBean> mMoreFollowList;
    private int leftBean;
    private Moreadapter1 mMoreadapter1;

    @Override
    protected void initEventAndData() {
        mPresenter.getTagsHotTab();

        mPresenter.getMoreFollowTab(Global.USERID, "bdf8c5dfcac34703a55ebff72ed48506", "0");
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
        return R.layout.activity_more_follow;
    }

    @Override
    protected IPMoreFollow<MoreFollow.MoreFollowV> createdPresenter() {
        return new IPMoreFollow<>();
    }

    @Override
    public void showTagsHotTab(TagsHotBean tagsHotBean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlv1.setLayoutManager(manager);
        mMoreadapter1 = new Moreadapter1(tagsHotBean.getData(), leftBean);
        mRlv1.setAdapter(mMoreadapter1);

        mMoreadapter1.setOnItemClick(new Moreadapter1.OnItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                mMoreadapter1.setThisPosition(position);
                String id = mMoreadapter1.mData.get(position).getId();
                mPresenter.getMoreFollowTab(Global.USERID, id, "0");
                mMoreadapter1.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showMoreFollowTab(final MoreFollowBean moreFollowBean) {
        mMoreFollowList = moreFollowBean.getMoreFollowList();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlv2.setLayoutManager(manager);
        mMoreadapter2 = new Moreadapter2(moreFollowBean.getMoreFollowList());
        mRlv2.setAdapter(mMoreadapter2);

        mMoreadapter2.setOnItmeClickAdd(new Moreadapter2.OnItmeClickAdd() {
            @Override
            public void onadd(int position) {

                String userId = mMoreFollowList.get(position).getUserId();
                Log.e("sagadfhdath", userId);
                mPresenter.getFollow(Global.USERID, userId, "0");
                Toast.makeText(MoreFollowActivity.this, "关注了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showFollow() {

    }

    @Override
    public void showTagsHotSearchTab(TagsSearchBean tagsSearchBean) {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRlv3.setLayoutManager(manager);
        final Moreadapter3 moreadapter3 = new Moreadapter3(mActivity,tagsSearchBean.getTagList(),leftBean);
        mRlv3.setAdapter(moreadapter3);

        moreadapter3.setOnItemClick(new Moreadapter1.OnItemClick() {
            @Override
            public void onItemClick(View v, int position) {
                moreadapter3.setThisPosition(position);
                String id = moreadapter3.mList.get(position).getId();
                mPresenter.getMoreFollowTab(Global.USERID, id, "0");
                moreadapter3.notifyDataSetChanged();
            }
        });
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


    @OnClick({R.id.back, R.id.search_text_quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.search_text_quxiao:
                String key = mSearchEdit.getText().toString();
                if(mSearchTextQuxiao.getText().toString().equals("取消")){
                    mSearchEdit.setText("");
                }
                mSearchEdit.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() == 0) {
                            mSearchTextQuxiao.setText("取消");
                            mRlv1.setVisibility(View.VISIBLE);
                            mRlv3.setVisibility(View.GONE);
                        } else {
                            mSearchTextQuxiao.setText("搜索");
                            mRlv3.setVisibility(View.VISIBLE);
                            mRlv1.setVisibility(View.GONE);
                        }
                        String s1 = mSearchEdit.getText().toString();
                        mPresenter.getTagsHotSearchTab(s1, "0");
                    }
                });
                break;
        }
    }
}
