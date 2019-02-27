package com.example.testnavigation.activeity.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.HomeActivity;
import com.example.testnavigation.activeity.LandingActivity;
import com.example.testnavigation.activeity.MainActivity;
import com.example.testnavigation.base.SimpleActivity;
import com.example.testnavigation.global.App;
import com.example.testnavigation.utils.DisplayUtils;
import com.example.testnavigation.utils.MessageSocket;
import com.example.testnavigation.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import fontsliderbar.FontSliderBar;

public class SetSizeActivity extends SimpleActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.headtoptext)
    TextView mHeadtoptext;
    @BindView(R.id.headtoptext2)
    TextView mHeadtoptext2;
    @BindView(R.id.main_top)
    RelativeLayout mMainTop;
    @BindView(R.id.tv_chatcontent)
    TextView mTvChatcontent2;
    @BindView(R.id.iv_userhead)
    ImageView mIvUserhead;
    @BindView(R.id.iv_userhead1)
    ImageView mIvUserhead1;
    @BindView(R.id.tv_chatcontent1)
    TextView mTvChatcontent1;
    @BindView(R.id.content_msg_view)
    RelativeLayout mContentMsgView;
    @BindView(R.id.iv_userhead3)
    ImageView mIvUserhead3;
    @BindView(R.id.tv_chatcontent3)
    TextView mTvChatcontent3;
    @BindView(R.id.fontSliderBar)
    FontSliderBar mFontSliderBar;
    private float textsize1, textsize2, textsize3;
    private float textSizef;//缩放比例
    private int currentIndex;
    private boolean isClickable = true;

    @Override
    protected void viewCreated() {

    }

    @Override
    protected void initEventAndData() {
        initData();
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_set_size;
    }

    private void initData() {
        currentIndex = App.getApplication().getPreferencesHelper().getValueInt("currentIndex", 1);
        textSizef = 1 + currentIndex * 0.1f;
        textsize1 = mTvChatcontent1.getTextSize() / textSizef;
        textsize2 = mTvChatcontent2.getTextSize() / textSizef;
        textsize3 = mTvChatcontent3.getTextSize() / textSizef;
        mFontSliderBar.setTickCount(6).setTickHeight(DisplayUtils.convertDip2Px(SetSizeActivity.this, 15)).setBarColor(Color.GRAY)
                .setTextColor(Color.BLACK).setTextPadding(DisplayUtils.convertDip2Px(SetSizeActivity.this, 10)).setTextSize(DisplayUtils.convertDip2Px(SetSizeActivity.this, 14))
                .setThumbRadius(DisplayUtils.convertDip2Px(SetSizeActivity.this, 10)).setThumbColorNormal(Color.GRAY).setThumbColorPressed(Color.GRAY)
                .setOnSliderBarChangeListener(new FontSliderBar.OnSliderBarChangeListener() {
                    @Override
                    public void onIndexChanged(FontSliderBar rangeBar, int index) {
                        if(index>5){
                            return;
                        }
                        index = index - 1;
                        float textSizef = 1 + index * 0.1f;
                        setTextSize(textSizef);
                    }
                }).setThumbIndex(currentIndex).withAnimation(false).applay();
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFontSliderBar.getCurrentIndex() != currentIndex) {
                    if (isClickable) {
                        isClickable = false;
                        refresh();
                    }
                } else {
                    finish();
                }
            }
        });
    }

    private void setTextSize(float textSize) {
        //改变当前页面的字体大小
        mTvChatcontent1.setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize1 * textSize));
        mTvChatcontent2.setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize2 * textSize));
        mTvChatcontent3.setTextSize(DisplayUtils.px2sp(SetSizeActivity.this, textsize3 * textSize));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (currentIndex != mFontSliderBar.getCurrentIndex()) {
                if (isClickable) {
                    isClickable = false;
                    refresh();
                }
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void refresh() {
        //存储标尺的下标
        App.getApplication().getPreferencesHelper().setValue("currentIndex", mFontSliderBar.getCurrentIndex());
        //通知主页面重启
        RxBus.getInstance().post(HomeActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
        //重启mainActivity
        RxBus.getInstance().post(HomeActivity.class.getSimpleName(), new MessageSocket(99, null, null, null));
//        showMyDialog();
        //2s后关闭  延迟执行任务 重启完主页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                hideMyDialog();
                finish();
            }
        }, 2000);
    }
}
