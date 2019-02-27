package com.example.testnavigation.fragment.mine;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.MainActivity;
import com.example.testnavigation.adapter.mine.Commentadapter3;
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
public class AttentionFragment extends BaseFragment<ListNotify.ListNotifyV, IPUserListNofity<ListNotify.ListNotifyV>> implements ListNotify.ListNotifyV {


    @BindView(R.id.rlv)
    SwipeMenuRecyclerView mRlv;
    Unbinder unbinder;
    private List<ListNotifyBean.DataBean> mData = new ArrayList<>();
    private Commentadapter3 mCommentadapter3;

    public AttentionFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_attention;
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
            if (listNotifyBean.getData().get(i).getNotifyType().equals("1")) {
                mData.add(listNotifyBean.getData().get(i));
            }
        }

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        //设置添加侧滑按钮
        mRlv.setSwipeMenuCreator(swipeMenuCreator);
        //设置滑动菜单item监听
        mRlv.setSwipeMenuItemClickListener(swipeMenuItemClickListener);
        mRlv.setLayoutManager(manager);
        mCommentadapter3 = new Commentadapter3(mData);
        mRlv.setAdapter(mCommentadapter3);
    }

    // 设置菜单监听器。
    SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        // 创建菜单：
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            SwipeMenuItem deleteItem = new SwipeMenuItem(mActivity)
                    .setBackground(R.color.colorPrimary)
                    .setTextColor(Color.WHITE)
                    .setText("置顶")
                    .setWidth(width)
                    .setHeight(height);
            swipeRightMenu.addMenuItem(deleteItem);
            SwipeMenuItem deleteItem2 = new SwipeMenuItem(mActivity)
                    .setBackground(R.color.colorAccent)
                    .setTextColor(Color.WHITE)
                    .setText("删除")
                    .setWidth(width)
                    .setHeight(height);
            swipeRightMenu.addMenuItem(deleteItem2);
        }
    };

    // 菜单点击监听。
    SwipeMenuItemClickListener swipeMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection();//左边还是右边菜单
            int adapterPosition = menuBridge.getAdapterPosition();//    RecyclerView的Item的position。
            int position = menuBridge.getPosition();// 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) { //如果是右边的菜单

                if (position == 0) {
                    mCommentadapter3.setTop(adapterPosition);
                    mRlv.scrollToPosition(0);
                }else if(position == 1){
                    mCommentadapter3.remove(adapterPosition);

                }
            }

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
