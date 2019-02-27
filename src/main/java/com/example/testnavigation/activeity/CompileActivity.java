package com.example.testnavigation.activeity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.CompileAdapter;
import com.example.testnavigation.adapter.inform.CompileAdapters;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.greend.MyChannelDao;
import com.example.testnavigation.brean.inform.ListNewsChannel;

import com.example.testnavigation.contact.IListNewsChannel;
import com.example.testnavigation.http.HttpGreendao;
import com.example.testnavigation.presenter.IListNewsChannelP;
import com.example.testnavigation.utils.DefaultItemTouchHelpCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CompileActivity extends BaseActivity<IListNewsChannel.ListNewsChannelV,IListNewsChannelP<IListNewsChannel.ListNewsChannelV>> implements IListNewsChannel.ListNewsChannelV {

    @BindView(R.id.img_quit)
    ImageView imgQuit;
    @BindView(R.id.ll)
    RelativeLayout ll;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.img_compile)
    TextView imgCompile;
    @BindView(R.id.recyclerFirst)
    RecyclerView recyclerFirst;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.recyclerSecond)
    RecyclerView recyclerSecond;
    int position;
    private List<String> mList=new ArrayList<>();
    private CompileAdapter mCompileAdapter;
    private ArrayList<String> mName;
    private ArrayList<String> mId;
    private boolean isClick = false;
    public static int a=0;
    public static int b=1;
    private List<MyChannelDao> mMyChannelDaos;
    private List<MyChannelDao> mMyChannelDaos1;
    private CompileAdapters mCompileAdapters;
    private DefaultItemTouchHelpCallback mCallback;
    private ItemTouchHelper mItemTouchHelper;
    private boolean ischeck=true;
    @Override
    protected void viewCreated() {

    }

    @Override
    protected IListNewsChannelP<IListNewsChannel.ListNewsChannelV> createdPresenter() {
        return new IListNewsChannelP<>();
    }


    @Override
    protected void initEventAndData() {

//        Intent intent = getIntent();
//        mName = intent.getStringArrayListExtra("name");
//        mId = intent.getStringArrayListExtra("id");

        //我的频道
        mMyChannelDaos = HttpGreendao.getInstance().selectChanne(true);
        recyclerFirst.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mCompileAdapter = new CompileAdapter(mMyChannelDaos,mActivity);
        recyclerFirst.setAdapter(mCompileAdapter);

        //添加频道
        mMyChannelDaos1 = HttpGreendao.getInstance().selectChanne(false);
        recyclerSecond.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mCompileAdapters = new CompileAdapters(mActivity, mMyChannelDaos1);
        recyclerSecond.setAdapter(mCompileAdapters);

        mCompileAdapter.setOnItemClick(new CompileAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                MyChannelDao myChannelDao = mCompileAdapter.mData.get(position);
                myChannelDao.setBo(false);
                HttpGreendao.getInstance().updataChanne(myChannelDao);

                mCompileAdapter.mData.remove(myChannelDao);
                mCompileAdapter.notifyDataSetChanged();

                mCompileAdapters.mData.add(myChannelDao);
                mCompileAdapters.notifyDataSetChanged();
            }
        });

        mCompileAdapters.setOnItemClick(new CompileAdapters.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                MyChannelDao myChannelDao = mCompileAdapters.mData.get(position);
                myChannelDao.setBo(true);
                HttpGreendao.getInstance().updataChanne(myChannelDao);

                mCompileAdapters.mData.remove(myChannelDao);
                mCompileAdapters.notifyDataSetChanged();

                mCompileAdapter.mData.add(myChannelDao);
                mCompileAdapter.notifyDataSetChanged();
            }
        });

        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                if (mMyChannelDaos != null) {
                    Collections.swap(mMyChannelDaos, srcPosition, targetPosition);
                    mCompileAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);
        mItemTouchHelper = new ItemTouchHelper(mCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerFirst);
    }

    @Override
    protected int createLayoutId() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
//设置修改状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//设置系统状态栏的颜色
            window.setStatusBarColor(getResources().getColor(R.color.home_toolbar_bgcolor));}
        return R.layout.activity_compile;
    }

    @OnClick({R.id.img_quit, R.id.img_compile})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.img_quit:
                if(mItemClick!=null){
                    mItemClick.itemclick(mCompileAdapter.mData);
                }
                finish();
                break;
            case R.id.img_compile:
//                if(imgCompile.getText().equals("编辑")){
//                    imgCompile.setText("完成");
//                    a=1;
//                }else {
//                    imgCompile.setText("编辑");
//                    a=0;
//        }
//                mCompileAdapter.notifyDataSetChanged();

                if(ischeck){
                    mCompileAdapter.isshow=true;
                    imgCompile.setText("完成");
                    mCompileAdapter.notifyDataSetChanged();
                    ischeck=false;
                }else{
                    mCompileAdapter.isshow=false;
                    imgCompile.setText("编辑");
                    mCompileAdapter.notifyDataSetChanged();
                    ischeck=true;
                }
                break;
        }
    }
    private static OnItemClick mItemClick;

    public interface OnItemClick{
        void itemclick(List<MyChannelDao> mChanneladapter);
    }
    public static void setOnItemClick(OnItemClick itemClick){
        mItemClick = itemClick;
    }


    @Override
    public void showListTab(List<ListNewsChannel.NewsChannelListBean> newsChannelListBeans) {

    }

    @Override
    public void showError(String error) {

    }


}
