package com.example.testnavigation.fragment.gambit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.SousuoInfoactivity;
import com.example.testnavigation.adapter.topic.Classifyadapter1;
import com.example.testnavigation.adapter.topic.Classifyadapter2;
import com.example.testnavigation.base.BaseFragment;
import com.example.testnavigation.brean.topic.TagsHotBean;
import com.example.testnavigation.brean.topic.TagsSearchBean;
import com.example.testnavigation.contact.TagsHot;
import com.example.testnavigation.presenter.IPTagsHot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment<TagsHot.TagsHotV, IPTagsHot<TagsHot.TagsHotV>> implements TagsHot.TagsHotV {


    @BindView(R.id.et)
    EditText mEt;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.rv1)
    RecyclerView mRv1;
    @BindView(R.id.rv2)
    RecyclerView mRv2;
    Unbinder unbinder;
    private List<TagsHotBean.DataBean> mDataBeans = new ArrayList<>();
    private Classifyadapter1 mClassifyadapter1;
    private List<TagsSearchBean.TagListBean> mTagListBeans=new ArrayList<>();
    private Classifyadapter2 mClassifyadapter2;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    protected int createLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getTagsHotTab();


        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mRv1.setLayoutManager(manager);
        mClassifyadapter1 = new Classifyadapter1(mActivity, mDataBeans);
        mRv1.setAdapter(mClassifyadapter1);

        mClassifyadapter1.setOnItmeClickClass1(new Classifyadapter1.OnItmeClickClass1() {
            @Override
            public void ondianji(int position) {
                Intent intent = new Intent(mActivity,SousuoInfoactivity.class);
                intent.putExtra("keyword",mDataBeans.get(position).getTag());
                startActivity(intent);
            }
        });

        LinearLayoutManager manager2 = new LinearLayoutManager(mActivity);
        mRv2.setLayoutManager(manager2);
        mClassifyadapter2 = new Classifyadapter2(mActivity, mTagListBeans);
        mRv2.setAdapter(mClassifyadapter2);

        mClassifyadapter2.setOnItmeClickClass2(new Classifyadapter2.OnItmeClickClass2() {
            @Override
            public void ondianji(int position) {
                Intent intent = new Intent(mActivity, SousuoInfoactivity.class);
                intent.putExtra("keyword",mTagListBeans.get(position).getTag());
                startActivity(intent);
            }
        });
        mPresenter.getTagsHotSearchTab("无人机", "0");
    }

    @Override
    protected IPTagsHot<TagsHot.TagsHotV> createPresemter() {
        return new IPTagsHot<>();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showTagsHotTab(TagsHotBean tagsHotBean) {
        Log.e("wGEFASCSdgv", tagsHotBean.getData().toString());
        mClassifyadapter1.addData(tagsHotBean.getData());
    }

    @Override
    public void showTagsHotSearchTab(TagsSearchBean tagsSearchBean) {
        mClassifyadapter2.addData(tagsSearchBean.getTagList());
    }

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

    @OnClick(R.id.tv)
    public void onViewClicked() {
        if(mTv.getText().toString().equals("取消")){
            mEt.setText("");
        }else{
            Intent in = new Intent(mActivity, SousuoInfoactivity.class);
            in.putExtra("keyword",mEt.getText().toString());
            startActivity(in);
        }

        mEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    mTv.setText("取消");
                    mRv1.setVisibility(View.VISIBLE);
                    mRv2.setVisibility(View.GONE);
                }else{
                    mTv.setText("搜索");
                    mRv2.setVisibility(View.VISIBLE);
                    mRv1.setVisibility(View.GONE);
                }
                String s1 = mEt.getText().toString();
                mPresenter.getTagsHotSearchTab(s1,"0");
            }
        });

    }
}
