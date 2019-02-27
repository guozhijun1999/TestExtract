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
import com.example.testnavigation.brean.mine.ListNotifyBean;

import java.util.List;

public class Commentadapter3 extends RecyclerView.Adapter {


    private List<ListNotifyBean.DataBean> mData;
    private Context mContext;
    private int mTop;

    public Commentadapter3(List<ListNotifyBean.DataBean> data) {
        mData = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_notify, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.mName.setText(mData.get(position).getNickname());
        Glide.with(mContext).load(mData.get(position).getHeadImagePath()).into(holder1.mImage);
        holder1.mTime.setText(mData.get(position).getNotifyTime());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void remove(int adapterPosition) {
        mData.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public void setTop(int adapterPosition) {
        ListNotifyBean.DataBean dataBean = mData.get(adapterPosition);
        mData.remove(dataBean);
        mData.add(0, dataBean);
        notifyItemMoved(adapterPosition, 0);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        private final TextView mName;
        private final ImageView mImage;
        private final TextView mTime;

        public MyViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.item_notify_name);
            mImage = itemView.findViewById(R.id.item_notify_image);
            mTime = itemView.findViewById(R.id.item_notify_time);
        }
    }

}
