package com.example.testnavigation.base;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.testnavigation.global.App;
import com.example.testnavigation.utils.MessageSocket;
import com.example.testnavigation.utils.RxBus;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public abstract class SimpleActivity extends AppCompatActivity implements BaseView{

    private Unbinder mBind;
    public Activity mActivity;
    public Observable observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        permission();   //上边的方法
        //PermissionsDispatcher动态权限插件调用
        SimpleActivityPermissionsDispatcher.NeedPermissionWithCheck(SimpleActivity.this);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        //腾讯bugly初始化
        CrashReport.initCrashReport(getApplicationContext(), "9d2b08aa49", false);
        //友盟统计初始化
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5c43ddd5b465f564f4000ae6");
        UMConfigure.setLogEnabled(true);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_GAME);
//        MobclickAgent.setSessionContinueMillis(1000);

        setContentView(createLayoutId());
        createProgressBar();
        mBind = ButterKnife.bind(this);

        observable = RxBus.getInstance().register(this.getClass().getSimpleName(), MessageSocket.class);
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MessageSocket>() {

            @Override
            public void accept(MessageSocket message) throws Exception {
                rxBusCall(message);
            }
        });
        mActivity=this;
        viewCreated();
        initEventAndData();

    }

    public void rxBusCall(MessageSocket message) {

        switch (message.id){
            case 99://重启 不带动画
                //           this.recreate();
                Intent intent = getIntent();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
                break;
        }
    }
    public int getColorById(int resId) {
        return ContextCompat.getColor(this, resId);
    }
    private void permission() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,//公共存储读写数据
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,//允许程序从非系统拨号器里输入电话号码
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS,
                    Manifest.permission.CAMERA};//允许访问摄像头进行拍照
            ActivityCompat.requestPermissions(SimpleActivity.this, mPermissionList, 123);
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void createProgressBar() {


    }

    protected abstract void viewCreated();

    protected abstract void initEventAndData();

    protected abstract int createLayoutId();

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(this.getClass().getSimpleName(), observable);
        if (mBind !=null){
            mBind.unbind();
        }
    }

    //重写字体缩放比例 api<25
    @Override
    public Resources getResources() {
        Resources res =super.getResources();
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
            Configuration config = res.getConfiguration();
            config.fontScale= App.getApplication().getFontScale();//1 设置正常字体大小的倍数
            res.updateConfiguration(config,res.getDisplayMetrics());
        }
        return res;
    }
    //重写字体缩放比例  api>25
    @Override
    protected void attachBaseContext(Context newBase) {
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
            final Resources res = newBase.getResources();
            final Configuration config = res.getConfiguration();
            config.fontScale=App.getApplication().getFontScale();//1 设置正常字体大小的倍数
            final Context newContext = newBase.createConfigurationContext(config);
            super.attachBaseContext(newContext);
        }else{
            super.attachBaseContext(newBase);
        }
    }

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void NeedPermission() {
        Log.e("789aaaa","NeedPermission走了");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SimpleActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void OnShowRationale(final PermissionRequest request) {
        Log.e("789bbbb","OnShowRationale走了");
    }

    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void OnPermissionDenied() {
        Log.e("789cccc","OnPermissionDenied走了");
    }

    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void OnNeverAskAgain() {
        Log.e("789dddd","OnNeverAskAgain走了");
    }
}
