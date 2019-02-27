package com.example.testnavigation.fragment.mine;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.mine.InformRlvadapter;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.contact.ListNotify;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserListNofity;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformFragment extends BaseFragment<ListNotify.ListNotifyV, IPUserListNofity<ListNotify.ListNotifyV>> implements ListNotify.ListNotifyV {


    @BindView(R.id.rlv)
    SwipeMenuRecyclerView mRlv;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.title)
    TextView mTitle;
    Unbinder unbinder;
    private List<ListNotifyBean.DataBean> mData = new ArrayList<>();
    private InformRlvadapter mRlvadapter;

    public InformFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_inform;
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
            if (listNotifyBean.getData().get(i).getNotifyType().equals("0")) {
                mData.add(listNotifyBean.getData().get(i));
            }
        }
        Log.e("------长度------", mData.size() + "");
        if (mData.size() == 0) {
            mRlv.setVisibility(View.GONE);
            mImage.setVisibility(View.VISIBLE);
            mTitle.setVisibility(View.VISIBLE);
        } else {
            LinearLayoutManager manager = new LinearLayoutManager(getContext());
            mRlv.setLayoutManager(manager);
            mRlvadapter = new InformRlvadapter(mActivity,mData);
            mRlv.setSwipeMenuCreator(mMSwipeMenuCreator);
            mRlv.setSwipeMenuItemClickListener(mEnuItemClickListener);
            mRlv.setAdapter(mRlvadapter);
        }
    }

    public SwipeMenuCreator mMSwipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
            SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity())
                    .setBackground(R.color.colorRed)
                    .setWidth(width)
                    .setHeight(height)
                    .setTextColor(Color.WHITE)
                    .setText("删除");
            swipeRightMenu.addMenuItem(deleteItem);
        }
    };

    public SwipeMenuItemClickListener mEnuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();
            int position1 = menuBridge.getAdapterPosition();
            mRlvadapter.mData.remove(position1);
            mRlvadapter.notifyDataSetChanged();
        }
    };

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
