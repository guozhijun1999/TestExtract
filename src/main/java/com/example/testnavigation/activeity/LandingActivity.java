package com.example.testnavigation.activeity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.greend.LandDao;
import com.example.testnavigation.http.HttpGreendao;
import com.example.testnavigation.utils.DaalogHelper;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LandingActivity extends AppCompatActivity {

    @BindView(R.id.landing_close)
    ImageView landingClose;
    @BindView(R.id.landing_et_name)
    EditText landingEtName;
    @BindView(R.id.landing_et_passward)
    EditText landingEtPassward;
    @BindView(R.id.landing_tv_code)
    TextView landingTvCode;
    @BindView(R.id.landing_btn_landing)
    ImageView landingBtnLanding;
    @BindView(R.id.landing_checkbox)
    ImageView landingCheckbox;
    @BindView(R.id.landing_tv_protocol)
    TextView landingTvProtocol;
    @BindView(R.id.landing_ym_wecth)
    ImageView landingYmWecth;
    @BindView(R.id.landing_ym_qq)
    ImageView landingYmQq;
    @BindView(R.id.landing_ym_xinlang)
    ImageView landingYmXinlang;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    private boolean isChecked = false;
    private String mPhoneCode;
    private String mAuthCode;
    private String mCodeRex;
    private String mIpone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        List<LandDao> select = HttpGreendao.getInstance().select();
        if(select.size()>0){
            Intent intent = new Intent(LandingActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @OnClick({R.id.landing_close, R.id.landing_et_name, R.id.landing_et_passward, R.id.landing_tv_code, R.id.landing_btn_landing, R.id.landing_checkbox, R.id.landing_tv_protocol, R.id.landing_ym_wecth, R.id.landing_ym_qq, R.id.landing_ym_xinlang})
    public void onViewClicked(View view) {
        mPhoneCode = landingEtName.getText().toString();
        mAuthCode = landingEtPassward.getText().toString();
        mCodeRex = "[0-9]{6}";
        mIpone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        switch (view.getId()) {
            case R.id.landing_close:
                finish();
                break;
            case R.id.landing_et_name:
                break;
            case R.id.landing_et_passward:
                break;
            case R.id.landing_tv_code:
                Random random = new Random();
                String result = "";
                for (int i = 0; i < 6; i++) {
                    result += random.nextInt(10);
                }
                final String finalResult = result;
                DaalogHelper.showProgressDlg(this,"正在发送验证码");
                //延时一秒给TextView存值
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        landingEtPassward.setText(finalResult);
                        DaalogHelper.stopProgressDlg();
                    }
                }, 1000);
                break;
            case R.id.landing_btn_landing:

                if (!isChecked) {
                    Toast.makeText(this,"未同意用户协议",Toast.LENGTH_SHORT).show();
                }else {
                    if (!mPhoneCode.isEmpty() && mPhoneCode.length() ==11 &&mPhoneCode.matches(mIpone)){
                        if (!mAuthCode.isEmpty() && mAuthCode.length()==6 &&mAuthCode.matches(mCodeRex)){
                            HttpGreendao.getInstance().insert(new LandDao(null,mPhoneCode));
                            startActivity(new Intent(LandingActivity.this,IconActivity.class));
                            finish();
                        }else {
                            Toast.makeText(this,"验证码错误",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this,"手机号输入错误",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.landing_checkbox:
                if (!isChecked) {
                    landingCheckbox.setImageResource(R.drawable.checkbox);
                    landingBtnLanding.setImageResource(R.mipmap.landing_landingss);
                    isChecked = true;
                } else {
                    landingCheckbox.setImageResource(R.drawable.checkboxs);
                    landingBtnLanding.setImageResource(R.mipmap.landing_landing);
                    isChecked = false;
                }
                break;
            case R.id.landing_tv_protocol:
                break;
            case R.id.landing_ym_wecth:
                break;
            case R.id.landing_ym_qq:
                break;
            case R.id.landing_ym_xinlang:
                break;
        }
    }
}
