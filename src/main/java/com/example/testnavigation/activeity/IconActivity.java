package com.example.testnavigation.activeity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testnavigation.R;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.brean.inform.UploadHeadImage;
import com.example.testnavigation.contact.IUploadHeadImage;
import com.example.testnavigation.global.Global;
import com.example.testnavigation.presenter.IUploadHeadImageP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IconActivity extends BaseActivity<IUploadHeadImage.UploadHeadImageV, IUploadHeadImageP<IUploadHeadImage.UploadHeadImageV>> implements IUploadHeadImage.UploadHeadImageV {

    @BindView(R.id.icon_image_via)
    ImageView iconImageVia;
    @BindView(R.id.icon_tv_via)
    TextView iconTvVia;
    @BindView(R.id.icon_et_name)
    EditText iconEtName;
    @BindView(R.id.icon_ok)
    ImageView iconOk;
    @BindView(R.id.icon_tv_skip)
    TextView iconTvSkip;
    @BindView(R.id.icon_image_colse)
    ImageView iconImageColse;
    @BindView(R.id.cons)
    ConstraintLayout cons;

    private PopupWindow mPopupWindow;
    public static final int mXiangCe = 0;
    public static final int mPaizhao = 1;


    private TextView mAlbum;
    private TextView mCamera1;
    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;
    //调用照相机返回图片文件
    private File tempFile;
    private File mFile1;

    @Override
    protected void initEventAndData() {

    }


    @Override
    protected int createLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_icon;

    }

    @OnClick({R.id.icon_image_via, R.id.icon_tv_via, R.id.icon_et_name, R.id.icon_ok, R.id.icon_tv_skip, R.id.icon_image_colse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.icon_image_via:
                break;
            case R.id.icon_tv_via:
                popu();
                break;
            case R.id.icon_et_name:

                break;
            case R.id.icon_ok:
                String string = iconEtName.getText().toString();
                if (string.isEmpty()) {
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    String name = iconEtName.getText().toString();
                    mPresenter.getUpdateInfo(Global.USERID, "", name, "", "", "");
                    startActivity(new Intent(IconActivity.this, HomeActivity.class));
                }
                break;
            case R.id.icon_tv_skip:


                final PopupWindow popupWindow = new PopupWindow(this);
                final View popupView = LayoutInflater.from(this).inflate(R.layout.icon_popu, null);
                popupWindow.setContentView(popupView);
                popupWindow.setWidth(800);//ViewGroup.LayoutParams.MATCH_PARENT
                popupWindow.setHeight(400);
                popupWindow.setBackgroundDrawable(this.getResources().getDrawable(
                        R.drawable.bg_popu));
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(cons, Gravity.CENTER, 0, 0);
                bgAlpha(1.0f);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        bgAlpha(1.0f);
                    }
                });


                final TextView text = popupView.findViewById(R.id.content);
                int num = (int) ((Math.random() * 9 + 1) * 10000000);
                text.setText("user" + num);
                popupView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iconEtName.setText(text.getText());
                        popupWindow.dismiss();
                    }
                });

                break;
            case R.id.icon_image_colse:
                break;
        }
    }



    private void popu() {
        mPopupWindow = new PopupWindow(this);
        View popView = LayoutInflater.from(this).inflate(R.layout.popupwindown, null);
        mPopupWindow.setContentView(popView);
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        mPopupWindow.setWidth(width);
        mPopupWindow.setHeight(height);
        ColorDrawable dw = new ColorDrawable(0x30000000);
        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);

        mPopupWindow.showAtLocation(popView, Gravity.TOP, 0, 0);

        popView.findViewById(R.id.tvTakePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机
                startActivityForResult(intent, mPaizhao);
                mPopupWindow.dismiss();
            }
        });
        popView.findViewById(R.id.tvSelectPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);//启动相册
                startActivityForResult(intent, mXiangCe);
                mPopupWindow.dismiss();
            }
        });
        popView.findViewById(R.id.tvDiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    /**
     * 设置窗口的背景透明度
     *
     * @param f 0.0-1.0
     */
    private void bgAlpha(float f) {
        WindowManager.LayoutParams layoutParams = mActivity.getWindow().getAttributes();
        layoutParams.alpha = f;
        mActivity.getWindow().setAttributes(layoutParams);
    }

    @Override
    protected IUploadHeadImageP<IUploadHeadImage.UploadHeadImageV> createdPresenter() {
        return new IUploadHeadImageP<>();
    }

    @Override
    public void showListIcon(UploadHeadImage uploadHeadImage) {

    }

    @Override
    public void showUpdateInfo() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case mPaizhao:
                Bundle extras = data.getExtras();
                Bitmap data1 = (Bitmap) extras.get("data");
                //iconImageVia.setImageBitmap(data1);
                RequestOptions requestOptions = RequestOptions.circleCropTransform();
                Glide.with(this).load(data1).apply(requestOptions).into(iconImageVia);
                iconTvVia.setText("更换图像");
                File file1 = getFile(data1);
                Log.e("48561324",file1.toString());
                mPresenter.getLisIcon(file1);
                break;
            case mXiangCe:
                if (data != null) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    RequestOptions requestOptions1 = RequestOptions.circleCropTransform();
                    Glide.with(this).load(BitmapFactory.decodeFile(picturePath)).apply(requestOptions1).into(iconImageVia);
                    File file = getFile(BitmapFactory.decodeFile(picturePath));
                    Log.d("moxun", "onActivityResult: " + file.getPath());
                    iconTvVia.setText("更换图像");
                    Log.e("48561324",picturePath.toString());
                    mPresenter.getLisIcon(file);
                }
                break;
        }
    }

    public File getFile(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        File file = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            int x = 0;
            byte[] b = new byte[1024 * 100];
            while ((x = is.read(b)) != -1) {
                fos.write(b, 0, x);
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
