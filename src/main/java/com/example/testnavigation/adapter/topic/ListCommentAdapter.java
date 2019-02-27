package com.example.testnavigation.adapter.topic;

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
import com.example.testnavigation.brean.topic.ListCommentBean;

import java.util.List;

public class ListCommentAdapter extends RecyclerView.Adapter<ListCommentAdapter.ViewHolder> {
    private Context context;
    private List<ListCommentBean.CommentListBean> mListBeans;

    public ListCommentAdapter(Context context, List<ListCommentBean.CommentListBean> listBeans) {
        this.context = context;
        mListBeans = listBeans;
    }

    @NonNull
    @Override
    public ListCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_listcomment,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListCommentAdapter.ViewHolder holder, int position) {
        holder.mName.setText(mListBeans.get(position).getNickname());
        holder.mTime.setText(mListBeans.get(position).getCommentTime());
        holder.mTitle.setText(mListBeans.get(position).getContent());
        Glide.with(context).load(mListBeans.get(position).getHeadImagePath()).into(holder.mImg);
    }

    @Override
    public int getItemCount() {
        return mListBeans.size();
    }

    public void addData(List<ListCommentBean.CommentListBean> commentList) {
        mListBeans.clear();
        mListBeans.addAll(commentList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImg;
        private final TextView mName;
        private final TextView mTime;
        private final TextView mTitle;
        private final TextView mLikes;
        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.topic_detail_item_headimg);
            mName = itemView.findViewById(R.id.topic_detail_item_headname);
            mTime = itemView.findViewById(R.id.topic_detail_item_time);
            mTitle = itemView.findViewById(R.id.topic_detail_item_title);
            mLikes = itemView.findViewById(R.id.topic_detail_item_likes);
        }
    }
}
