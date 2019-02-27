package com.example.testnavigation.adapter.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testnavigation.R;
import com.example.testnavigation.brean.mine.ListFollowBean;

import java.util.List;

public class ListFollowadapter extends RecyclerView.Adapter {
    private List<ListFollowBean.FollowListBean> mData;
    private Context mContext;

    public ListFollowadapter(List<ListFollowBean.FollowListBean> followList) {
        mData = followList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_follow, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;

        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(mContext).load(mData.get(position).getHeadImagePath()).apply(options).into(holder1.mImage);

        if(mData.get(position).getNickname()==null){
            holder1.mName.setText("暂无昵称");
        }else{
            holder1.mName.setText(mData.get(position).getNickname() + "");
        }


        holder1.mTiem.setText(mData.get(position).getFollowTime());
        if(mData.get(position).getPersonalProfile()==null){
            holder1.mProfile.setText("该用户暂无简介");
        }else{
            holder1.mProfile.setText(mData.get(position).getPersonalProfile()+"");
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImage;
        private final TextView mName;
        private final TextView mTiem;
        private final TextView mProfile;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.name);
            mTiem = itemView.findViewById(R.id.time);
            mProfile = itemView.findViewById(R.id.profile);
        }
    }
}
