package com.example.testnavigation.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.mine.Commentadapter4;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.contact.ListNotify;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserListNofity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends BaseFragment<ListNotify.ListNotifyV, IPUserListNofity<ListNotify.ListNotifyV>> implements ListNotify.ListNotifyV {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;
    private List<ListNotifyBean.DataBean> mData = new ArrayList<>();
    public LikeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_like;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getListNotifyTab(Global.USERID);
    }

    @Override
    protected IPUserListNofity<ListNotify.ListNotifyV> createPresemter() {
        return new IPUserListNofity<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showListNotifyTab(ListNotifyBean listNotifyBean) {
        mData.clear();
        for (int i = 0; i < listNotifyBean.getData().size(); i++) {
            if (listNotifyBean.getData().get(i).getNotifyType().equals("3")) {
                mData.add(listNotifyBean.getData().get(i));
            }
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(manager);
        Commentadapter4 commentadapter4 = new Commentadapter4(mData);
        mRlv.setAdapter(commentadapter4);
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
}
