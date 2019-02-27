package com.example.testnavigation.adapter.topic;

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
import com.example.testnavigation.brean.topic.LoadTopicBean;

import java.util.List;

public class ChoicenessAdapter extends RecyclerView.Adapter<ChoicenessAdapter.ViewHolder>{
    private Context context;
    private List<LoadTopicBean.TopicListBean> mListBeans;

    public ChoicenessAdapter(Context context, List<LoadTopicBean.TopicListBean> listBeans) {
        this.context = context;
        mListBeans = listBeans;
    }

    @NonNull
    @Override
    public ChoicenessAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_choiceness, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChoicenessAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(mListBeans.get(position).getHeadImagePath()).into(holder.mIv1);
        holder.mName.setText(mListBeans.get(position).getNickname());
        holder.mTime.setText(mListBeans.get(position).getPublishTime());
        holder.mTitle.setText(mListBeans.get(position).getTitle());

        List<String> imageListThumb = (List<String>) mListBeans.get(position).getImageListThumb();
        if (imageListThumb!=null){
            if(imageListThumb.size()==3){
                Glide.with(context).load(imageListThumb.get(0)).into(holder.mImage1);
                Glide.with(context).load(imageListThumb.get(1)).into(holder.mImage2);
                Glide.with(context).load(imageListThumb.get(2)).into(holder.mImage3);
            }else if(imageListThumb.size()==2){
                Glide.with(context).load(imageListThumb.get(0)).into(holder.mImage1);
                Glide.with(context).load(imageListThumb.get(1)).into(holder.mImage2);
            }else{
                Glide.with(context).load(imageListThumb.get(0)).into(holder.mImage1);
            }
        }
        holder.mRead.setText(mListBeans.get(position).getPageviews()+"");
        holder.mComment.setText(mListBeans.get(position).getComments()+"");
        holder.mLike.setText(mListBeans.get(position).getLikes()+"");

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

    public void addData(String cursor, List<LoadTopicBean.TopicListBean> topicList) {
        mListBeans.clear();
        mListBeans.addAll(topicList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIv1;
        private final TextView mName;
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage1;
        private final ImageView mImage2;
        private final ImageView mImage3;
        private final TextView mRead;
        private final TextView mComment;
        private final TextView mLike;
        public ViewHolder(View itemView) {
            super(itemView);
            mIv1 = itemView.findViewById(R.id.topic_iv1);
            mName = itemView.findViewById(R.id.topic_headname);
            mTitle = itemView.findViewById(R.id.topic_title);
            mTime = itemView.findViewById(R.id.topic_time);
            mImage1 = itemView.findViewById(R.id.topic_image1);
            mImage2 = itemView.findViewById(R.id.topic_image2);
            mImage3 = itemView.findViewById(R.id.topic_image3);
            mRead = itemView.findViewById(R.id.topic_read_number);
            mComment = itemView.findViewById(R.id.topic_comment_number);
            mLike = itemView.findViewById(R.id.topic_likes_number);
        }
    }
}
