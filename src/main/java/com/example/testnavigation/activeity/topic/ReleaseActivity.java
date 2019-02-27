package com.example.testnavigation.activeity.topic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.topic.FaImageAdapter;
import com.example.testnavigation.base.BaseActivity;
import com.example.testnavigation.contact.InsertTopic;
import com.example.testnavigation.presenter.IPInsertTopic;
import com.example.testnavigation.utils.BitmapUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class ReleaseActivity extends BaseActivity<InsertTopic.InsertTopicV, IPInsertTopic<InsertTopic.InsertTopicV>> implements InsertTopic.InsertTopicV {

    @BindView(R.id.release_return)
    ImageView releaseReturn;
    @BindView(R.id.release_release)
    TextView releaseRelease;
    @BindView(R.id.release_view1)
    View releaseView1;
    @BindView(R.id.release_select)
    TextView releaseSelect;
    @BindView(R.id.release_tag)
    ImageView releaseTag;
    @BindView(R.id.release_edit)
    EditText releaseEdit;
    @BindView(R.id.release_addimg)
    ImageView releaseAddimg;
    @BindView(R.id.release_addvideo)
    ImageView releaseAddvideo;
    @BindView(R.id.release_addshare)
    ImageView releaseAddshare;
    @BindView(R.id.release_linear)
    LinearLayout releaseLinear;
    @BindView(R.id.fabu_recycler)
    RecyclerView mFabuRecycler;
    private List<String> mList = new ArrayList<>();
    private FaImageAdapter mFaImageAdapter;
    ArrayList<String> strings = new ArrayList<>();
    List<File> filelist = new ArrayList<>();
    @Override
    protected void initEventAndData() {
        mList.add("haha");
        mFabuRecycler.setLayoutManager(new GridLayoutManager(this,3));
        mFaImageAdapter = new FaImageAdapter(mActivity,mList);
        mFabuRecycler.setAdapter(mFaImageAdapter);

        mFaImageAdapter.setOnClickListener(new FaImageAdapter.OnClickListener() {
            @Override
            public void onclicks(int position) {
                if (mList.size()<10){
                    MultiImageSelector.create(ReleaseActivity.this)
                            .showCamera(true) // 是否显示相机. 默认为显示
                            .count(9) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                            // 单选模式 .single()
                            .multi() // 多选模式, 默认模式;
                            .origin(strings)
                            // 默认已选择图片. 只有在选择模式为多选时有效
                            .start(ReleaseActivity.this, 1); //最后一个参数为暗号是个int值
                } else {
                    Toast.makeText(ReleaseActivity.this, "最多只能选取9张图片", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFaImageAdapter.setOnLongClickListener(new FaImageAdapter.OnLongClickListener() {
            @Override
            public void onclicklongs(int position) {
                mList.remove(position);
                mFaImageAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data !=null){
            ArrayList<String> str = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);

            for(int i=0;i<str.size();i++){
                String  s= BitmapUtils.compressImageUpload(str.get(i));
                mList.add(0,s);
            }
            mFaImageAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_release;
    }

    @Override
    protected IPInsertTopic<InsertTopic.InsertTopicV> createdPresenter() {
        return new IPInsertTopic<>();
    }

    @Override
    public void showInsertTopic() {

    }

    @Override
    public void showError(String error) {
        Log.e("图片错误54646",error.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.release_return, R.id.release_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.release_return:
                finish();
                break;
            case R.id.release_release:
                String string = releaseEdit.getText().toString();
                if (string != null) {
                    for (int i=0;i<mList.size();i++){
                        File file=new File(mList.get(i));
                        filelist.add(file);
                    }
                    mPresenter.getInsertTopic(string, filelist);
                    Toast.makeText(ReleaseActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
        }
    }
}
