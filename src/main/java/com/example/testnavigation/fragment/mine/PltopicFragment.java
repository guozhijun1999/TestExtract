package com.example.testnavigation.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.mine.CommentAdapter1;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.mine.UserListCommentBean;
import com.example.testnavigation.contact.UserListComment;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserListComment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PltopicFragment extends BaseFragment<UserListComment.ListCommentV, IPUserListComment<UserListComment.ListCommentV>> implements UserListComment.ListCommentV {


    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;
    private List<UserListCommentBean.UserCommentListBean> mData=new ArrayList<>();
    public  PltopicFragment() {
        // Required empty public constructor
    }


    @Override
    protected int createLayoutId() {
        return R.layout.fragment_pltopic;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void load() {
        mPresenter.getListCommentTab(Global.USERID);
        super.load();
    }

    @Override
    protected IPUserListComment<UserListComment.ListCommentV> createPresemter() {
        return new IPUserListComment<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showListCommentTab(UserListCommentBean userListCommentBean) {
        for (int i = 0; i < userListCommentBean.getUserCommentList().size(); i++) {
            if (userListCommentBean.getUserCommentList().get(i).getObjectType().equals("1")) {
                mData.add(userListCommentBean.getUserCommentList().get(i));
            }
        }

        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mRlv.setLayoutManager(manager);
        CommentAdapter1 commentAdapter1 = new CommentAdapter1(mData, mActivity);
        mRlv.setAdapter(commentAdapter1);
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
