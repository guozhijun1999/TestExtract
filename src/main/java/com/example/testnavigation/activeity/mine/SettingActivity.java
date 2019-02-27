package com.example.testnavigation.activeity.mine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.LandingActivity;
import com.example.testnavigation.base.SimpleActivity;
import com.example.testnavigation.http.HttpGreendao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends SimpleActivity {

    @BindView(R.id.myoptions_return)
    ImageView mMyoptionsReturn;
    @BindView(R.id.myoptions_cache)
    ImageView mMyoptionsCache;
    @BindView(R.id.myoptions_tv_cache)
    TextView mMyoptionsTvCache;
    @BindView(R.id.huancun)
    RelativeLayout mHuancun;
    @BindView(R.id.myoptions_textsize)
    ImageView mMyoptionsTextsize;
    @BindView(R.id.zhiti)
    RelativeLayout mZhiti;
    @BindView(R.id.myoptions_switch)
    Switch mMyoptionsSwitch;
    @BindView(R.id.xiazai)
    RelativeLayout mXiazai;
    @BindView(R.id.myoptions_into)
    ImageView mMyoptionsInto;
    @BindView(R.id.guanyu)
    RelativeLayout mGuanyu;
    @BindView(R.id.myoptions_exit)
    LinearLayout mMyoptionsExit;

    @Override
    protected void viewCreated() {

    }

    @Override
    protected void initEventAndData() {

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
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.myoptions_return, R.id.myoptions_textsize, R.id.zhiti, R.id.myoptions_exit,R.id.huancun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myoptions_return:
                finish();
                break;
            case R.id.myoptions_textsize:
                break;
            case R.id.zhiti:
                Intent intent = new Intent(SettingActivity.this,SetSizeActivity.class);
                startActivity(intent);
                break;
            case R.id.myoptions_exit:
                HttpGreendao.getInstance().empty();
                startActivity(new Intent(SettingActivity.this, LandingActivity.class));
                break;
            case R.id.huancun:
                mMyoptionsTvCache.setText("0M");
                break;
        }
    }

}
