package com.example.testnavigation.activeity.mine;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testnavigation.R;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.mine.UserInfoBean;
import com.example.testnavigation.contact.UserInfo;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IPUserInfo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModificationActivity extends BaseActivity<UserInfo.UserInfoV, IPUserInfo<UserInfo.UserInfoV>> implements UserInfo.UserInfoV {

    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.edit1)
    TextView mEdit1;
    @BindView(R.id.head)
    ImageView mHead;
    @BindView(R.id.iv2)
    ImageView mIv2;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.iv3)
    ImageView mIv3;
    @BindView(R.id.sex)
    EditText mSex;
    @BindView(R.id.iv4)
    ImageView mIv4;
    @BindView(R.id.day)
    EditText mDay;
    @BindView(R.id.iv5)
    ImageView mIv5;
    @BindView(R.id.person)
    EditText mPerson;
    @BindView(R.id.iv6)
    ImageView mIv6;
    @BindView(R.id.iv7)
    ImageView mIv7;
    @BindView(R.id.xinxi)
    TextView mXinxi;
    @BindView(R.id.bt)
    Button mBt;

    @Override
    protected void initEventAndData() {
        mPresenter.getUserInfoTab(Global.USERID);
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
        return R.layout.activity_modification;
    }

    @Override
    protected IPUserInfo<UserInfo.UserInfoV> createdPresenter() {
        return new IPUserInfo<>();
    }

    @Override
    public void showUserInfoTab(UserInfoBean userInfoBean) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(this).load(userInfoBean.getHeadImagePath()).apply(requestOptions).into(mHead);

        mName.setText(userInfoBean.getNickname());
        mSex.setText(userInfoBean.getSex());
        mDay.setText(userInfoBean.getBirthday());
        mPerson.setText(userInfoBean.getProfessionName() + "");
    }

    @Override
    public void showUpdateInfo() {

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

    @OnClick({R.id.iv, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv:
                finish();
                break;
            case R.id.iv2:
                break;
            case R.id.iv3:
                mName.setEnabled(true);
                break;
            case R.id.iv4:
                mSex.setEnabled(true);
                break;
            case R.id.iv5:
                mDay.setEnabled(true);
                break;
            case R.id.iv6:
                mPerson.setEnabled(true);
                break;
            case R.id.iv7:
                break;
            case R.id.bt:
                String name = mName.getText().toString();
                String sex = mSex.getText().toString();
                String day = mDay.getText().toString();
                String person = mPerson.getText().toString();
                mPresenter.getUpdateInfo(Global.USERID, day, name, "", person, sex);
                Toast.makeText(this,"上传成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
