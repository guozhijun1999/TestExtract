package com.example.testnavigation.fragment.gambit;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testnavigation.R;
import com.example.testnavigation.adapter.inform.HomeAdapter;
import com.example.testnavigation.base.SimpleFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GambitFragment extends SimpleFragment {


    @BindView(R.id.gambit_tab)
    TabLayout gambitTab;
    @BindView(R.id.gambit_vp)
    ViewPager gambitVp;
    Unbinder unbinder;

    public GambitFragment() {
        // Required empty public constructor
    }


    @Override
    protected int createLayoutId() {
        return R.layout.fragment_gambit;
    }

    @Override
    protected void initEventAndData() {
        ArrayList<Fragment> fragments= new ArrayList<>();
        TopicFragment topicFragment = new TopicFragment();
        ChoicenessFragment choicenessFragment = new ChoicenessFragment();
        ClassifyFragment classifyFragment = new ClassifyFragment();
        fragments.add(topicFragment);
        fragments.add(choicenessFragment);
        fragments.add(classifyFragment);
        gambitTab.addTab(gambitTab.newTab().setText("话题"));
        gambitTab.addTab(gambitTab.newTab().setText("精选"));
        gambitTab.addTab(gambitTab.newTab().setText("分类"));
        gambitTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                gambitVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        gambitVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(gambitTab));
        gambitVp.setAdapter(new HomeAdapter(getChildFragmentManager(),fragments));
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
}
