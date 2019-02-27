package com.example.testnavigation.adapter.topic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.topic.TagsSearchBean;

import java.util.List;

public class Classifyadapter2 extends RecyclerView.Adapter<Classifyadapter2.ViewHolder> {
    Context context;
    List<TagsSearchBean.TagListBean> mList;

    public Classifyadapter2(Context context, List<TagsSearchBean.TagListBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_classify1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TagsSearchBean.TagListBean tagListBean = mList.get(position);
        holder.mTitle.setText(tagListBean.getTag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItmeClickClass2.ondianji(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<TagsSearchBean.TagListBean> tagList) {
        mList.clear();
        mList.addAll(tagList);
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

    private OnItmeClickClass2 mOnItmeClickClass2;

    public void setOnItmeClickClass2(OnItmeClickClass2 onItmeClickClass2) {
        mOnItmeClickClass2 = onItmeClickClass2;
    }

    public interface OnItmeClickClass2 {
        void ondianji(int position);
    }
}
