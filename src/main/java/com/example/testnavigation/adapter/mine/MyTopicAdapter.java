package com.example.testnavigation.adapter.mine;

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
import com.example.testnavigation.brean.mine.ListTopicBean;

import java.util.List;

public class MyTopicAdapter extends RecyclerView.Adapter<MyTopicAdapter.ViewHolder> {
    private Context mContext;
    private List<ListTopicBean.FavouritTopicListBean> mData;

    public MyTopicAdapter(Context context, List<ListTopicBean.FavouritTopicListBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public MyTopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_usertopic,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyTopicAdapter.ViewHolder holder, final int position) {
        holder.mTime.setText(mData.get(position).getPublishTime());
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mRead.setText(mData.get(position).getPageviews()+"");
        holder.mComment.setText(mData.get(position).getComments()+"");
        holder.mLike.setText(mData.get(position).getLikes()+"");
        List<String> imageListThumb = (List<String>) mData.get(position).getImageListThumb();
        if(imageListThumb!=null && imageListThumb.size()!=0){
            Glide.with(mContext).load(imageListThumb.get(0)).into(holder.mImage);
        }else{
            Glide.with(mContext).load(R.mipmap.meitu).into(holder.mImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TopicDetailsActivity.class);
                intent.putExtra("topicId",mData.get(position).getTopicId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTime;
        private final TextView mTitle;
        private final TextView mRead;
        private final TextView mBianji;
        private final TextView mComment;
        private final TextView mLike;
        private final ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.item_userTopic_time);
            mTitle = itemView.findViewById(R.id.item_userTopic_title);
            mRead = itemView.findViewById(R.id.item_userTopic_readSize);
            mBianji = itemView.findViewById(R.id.item_userTopic_bianJi);
            mComment = itemView.findViewById(R.id.item_userTopic_commentSize);
            mLike = itemView.findViewById(R.id.item_userTopic_likeSize);
            mImage = itemView.findViewById(R.id.item_userTopic_image);
        }
    }
}
