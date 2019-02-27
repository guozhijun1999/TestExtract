package com.example.testnavigation.adapter.mine;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.topic.TagsHotBean;

import java.util.List;

public class Moreadapter1 extends RecyclerView.Adapter {

    public List<TagsHotBean.DataBean> mData;
    private Context mContext;
    private OnItemClick mOnItemClick;
    private int thisPosition;


    public int getthisPosition() {
        return thisPosition;
    }
    public Moreadapter1(List<TagsHotBean.DataBean> data,int thisPosition) {
        mData = data;
        this.thisPosition = thisPosition;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_more_1, null, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder holder1 = (MyViewHolder) holder;
        if (position == getthisPosition()) {
//            holder1.mTitle.setBackgroundColor(Color.GRAY);
            holder1.mTitle.setBackgroundResource(R.color.bg_focus2);
        } else {
            holder1.mTitle.setBackgroundResource(R.color.colorWhite);
        }
        holder1.mTitle.setText(mData.get(position).getTag());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClick!=null){
                    mOnItemClick.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView mTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
        }
    }

    public interface OnItemClick{
        void onItemClick(View v,int position);
    }
    public void setOnItemClick(OnItemClick onItemClick){
        mOnItemClick = onItemClick;
    }
}
