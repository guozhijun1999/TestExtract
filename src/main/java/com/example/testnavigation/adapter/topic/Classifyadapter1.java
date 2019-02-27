package com.example.testnavigation.adapter.topic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.topic.TagsHotBean;

import java.util.List;

public class Classifyadapter1 extends RecyclerView.Adapter<Classifyadapter1.ViewHolder> {
    private Context mContext;
    private List<TagsHotBean.DataBean> mData;

    public Classifyadapter1(Context context, List<TagsHotBean.DataBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public Classifyadapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(mContext).inflate(R.layout.layout_classify1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Classifyadapter1.ViewHolder holder, final int position) {
        String tag = mData.get(position).getTag();

        holder.mTitle.setText(tag);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItmeClickClass1.ondianji(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addData(List<TagsHotBean.DataBean> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mJiantou;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mJiantou = itemView.findViewById(R.id.hot_jiantou);
        }
    }
    private OnItmeClickClass1 mOnItmeClickClass1;

    public void setOnItmeClickClass1(OnItmeClickClass1 onItmeClickClass1) {
        mOnItmeClickClass1 = onItmeClickClass1;
    }

    public interface OnItmeClickClass1{
        void ondianji(int position);
    }
}
