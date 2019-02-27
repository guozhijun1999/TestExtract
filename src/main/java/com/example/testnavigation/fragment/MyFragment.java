package com.example.testnavigation.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testnavigation.R;
import com.example.testnavigation.activeity.mine.AttentionActivity;
import com.example.testnavigation.activeity.mine.CollectActivity;
import com.example.testnavigation.activeity.mine.CommentActivity;
import com.example.testnavigation.activeity.mine.InformActivity;
import com.example.testnavigation.activeity.mine.ModificationActivity;
import com.example.testnavigation.activeity.mine.MyTopicActivity;
import com.example.testnavigation.activeity.mine.SettingActivity;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.mine.FastLoginBean;
import com.example.testnavigation.contact.FastLogin;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPFastLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<FastLogin.FastLoginV, IPFastLogin<FastLogin.FastLoginV>> implements FastLogin.FastLoginV {


    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.edit)
    TextView edit;
    @BindView(R.id.collect)
    TextView collect;
    @BindView(R.id.sc)
    TextView sc;
    @BindView(R.id.history)
    TextView history;
    @BindView(R.id.ls)
    TextView ls;
    @BindView(R.id.imported)
    TextView imported;
    @BindView(R.id.gz)
    TextView gz;
    @BindView(R.id.discuss)
    TextView discuss;
    @BindView(R.id.pl)
    TextView pl;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.ni)
    TextView ni;
    @BindView(R.id.open)
    ImageView open;
    @BindView(R.id.inform)
    LinearLayout inform;
    @BindView(R.id.my_topic)
    TextView myTopic;
    @BindView(R.id.open1)
    ImageView open1;
    @BindView(R.id.feedback)
    TextView feedback;
    @BindView(R.id.open3)
    ImageView open3;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.open4)
    ImageView open4;
    @BindView(R.id.ll_set)
    LinearLayout llSet;
    Unbinder unbinder;
    @BindView(R.id.ll_topic)
    LinearLayout mLlTopic;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    protected int createLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getFastLoginTab(Global.USERID, "1", "1.0.0");
    }

    @Override
    public void load() {
        super.load();

    }

    @Override
    protected IPFastLogin<FastLogin.FastLoginV> createPresemter() {
        return new IPFastLogin<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showFastLoginTab(FastLoginBean fastLoginBean) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(fastLoginBean.getHeadImagePath()).apply(requestOptions).into(iv);
        Log.e("96354611", fastLoginBean.getHeadImagePath().toString());
        name.setText(fastLoginBean.getNickname());
        collect.setText(fastLoginBean.getFavorites() + "");
        history.setText(fastLoginBean.getHistoryReads() + "");
        imported.setText(fastLoginBean.getFollowing() + "");
        discuss.setText(fastLoginBean.getComments() + "");
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.edit, R.id.sc, R.id.ls, R.id.gz, R.id.pl, R.id.inform,R.id.ll_topic, R.id.ll_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.edit:
                startActivity(new Intent(mActivity, ModificationActivity.class));
                break;
            case R.id.sc:
                startActivity(new Intent(mActivity, CollectActivity.class));
                break;
            case R.id.ls:

                break;
            case R.id.gz:
                startActivity(new Intent(mActivity, AttentionActivity.class));
                break;
            case R.id.pl:
                startActivity(new Intent(mActivity, CommentActivity.class));
                break;
            case R.id.inform:
                startActivity(new Intent(mActivity, InformActivity.class));
                break;
            case R.id.ll_topic:
                startActivity(new Intent(getContext(), MyTopicActivity.class));
                break;
            case R.id.ll_set:
                startActivity(new Intent(mActivity, SettingActivity.class));
                break;
        }
    }

}
