package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.TopicDetailsActivity;
import com.example.testnavigation.brean.inform.SearchTopicBean;

import java.util.ArrayList;
import java.util.List;

public class HuaTiAdapter extends RecyclerView.Adapter<HuaTiAdapter.ViewHolder> {
    Context context;
    List<SearchTopicBean.DataBean.TopicListBean> mListBeans;

    public HuaTiAdapter(Context context, List<SearchTopicBean.DataBean.TopicListBean> listBeans) {
        this.context = context;
        mListBeans = listBeans;
    }

    @NonNull
    @Override
    public HuaTiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_topic,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HuaTiAdapter.ViewHolder holder, final int position) {
        SearchTopicBean.DataBean.TopicListBean topicListBean = mListBeans.get(position);
        Glide.with(context).load(topicListBean.getHeadImagePath()).into(holder.mIv1);
        holder.mName.setText(topicListBean.getNickname());
        holder.mTime.setText(topicListBean.getPublishTime());
        holder.mTitle.setText(topicListBean.getTitle());
        if (topicListBean.getImageListThumb()!=null){
            Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
        }else {
            Glide.with(context).load(topicListBean.getHeadImagePath()).into(holder.mImage);
        }

        holder.mRead.setText(topicListBean.getLikes()+"");
        holder.mComment.setText(topicListBean.getComments()+"");
        holder.mLike.setText(topicListBean.getLikes()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopicDetailsActivity.class);
                intent.putExtra("topicId",mListBeans.get(position).getTopicId());
                intent.putExtra("userId",mListBeans.get(position).getUserId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListBeans.size();
    }

    public void addData(List<SearchTopicBean.DataBean.TopicListBean> topicList) {
        mListBeans.clear();
        mListBeans.addAll(topicList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIv1;
        private final TextView mName;
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage;
        private final TextView mRead;
        private final TextView mComment;
        private final TextView mLike;
        public ViewHolder(View itemView) {
            super(itemView);
            mIv1 = itemView.findViewById(R.id.topic_iv1);
            mName = itemView.findViewById(R.id.topic_headname);
            mTitle = itemView.findViewById(R.id.topic_title);
            mTime = itemView.findViewById(R.id.topic_time);
            mImage = itemView.findViewById(R.id.topic_image);
            mRead = itemView.findViewById(R.id.topic_read_number);
            mComment = itemView.findViewById(R.id.topic_comment_number);
            mLike = itemView.findViewById(R.id.topic_likes_number);
        }
    }
}
