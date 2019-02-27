package com.example.testnavigation.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class SimpleFragment extends Fragment {
    public Context context;
    public Activity mActivity;
    private Unbinder mBind;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(createLayoutId(),null);
    }

    protected abstract int createLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createProgressBar();
        mBind = ButterKnife.bind(this, view);
        initEventAndData();
    }

    public void createProgressBar() {

    }


    protected abstract void initEventAndData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        load();
    }

    private void load() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBind!=null){
            mBind.unbind();
        }
    }
}
