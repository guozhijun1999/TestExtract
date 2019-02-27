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
import com.example.testnavigation.R;
import com.example.testnavigation.brean.mine.MoreFollowBean;

import java.util.List;

public class Moreadapter2 extends RecyclerView.Adapter {

    private List<MoreFollowBean.MoreFollowListBean> mData;
    private Context mContext;

    public Moreadapter2(List<MoreFollowBean.MoreFollowListBean> moreFollowList) {
        mData =moreFollowList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_more_2, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Glide.with(mContext).load(mData.get(position).getHeadImagePath()).into(holder1.mImage);
        holder1.mName.setText(mData.get(position).getNickname());
        holder1.mGuan.setText(mData.get(position).getFollowers()+"关注");
        holder1.mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItmeClickAdd.onadd(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{


        private final ImageView mImage;
        public final ImageView mAdd;
        private final TextView mName;
        private final TextView mGuan;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mAdd = itemView.findViewById(R.id.add);
            mName = itemView.findViewById(R.id.name);
            mGuan = itemView.findViewById(R.id.guan);
        }
    }
    private OnItmeClickAdd mOnItmeClickAdd;

    public void setOnItmeClickAdd(OnItmeClickAdd onItmeClickAdd) {
        mOnItmeClickAdd = onItmeClickAdd;
    }

    public interface OnItmeClickAdd{
        void onadd(int position);
    }
}
