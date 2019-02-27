package com.example.testnavigation.adapter.topic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.activeity.topic.TopicDetailsActivity;
import com.example.testnavigation.brean.topic.LoadTopicBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class TopicAdapter extends XRecyclerView.Adapter<TopicAdapter.ViewHolder>{
    private Context context;
    private List<LoadTopicBean.TopicListBean> mList;


    public TopicAdapter(Context context, List<LoadTopicBean.TopicListBean> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_topic,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final LoadTopicBean.TopicListBean topicListBean = mList.get(position);
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

//        if(topicListBean.getImageListThumb()!=null){
//            if(topicListBean.getImageListThumb().size()==1) {
//                Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//            }else if(topicListBean.getImageListThumb().size()==2){
//                Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//                Glide.with(context).load(topicListBean.getImageListThumb().get(1)).into(holder.mImage2);
//            }else if(topicListBean.getImageListThumb().size()==3){
//                Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//                Glide.with(context).load(topicListBean.getImageListThumb().get(1)).into(holder.mImage2);
//                Glide.with(context).load(topicListBean.getImageListThumb().get(2)).into(holder.mImage3);
//            }
//        }

//        if (topicListBean.getImageListThumb().size()>=3) {
//            Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//            Glide.with(context).load(topicListBean.getImageListThumb().get(1)).into(holder.mImage2);
//            Glide.with(context).load(topicListBean.getImageListThumb().get(2)).into(holder.mImage3);
//        } else if (topicListBean.getImageListThumb().size()==2){
//            Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//            Glide.with(context).load(topicListBean.getImageListThumb().get(1)).into(holder.mImage2);
//        }else if (topicListBean.getImageListThumb().size()==1) {
//            Glide.with(context).load(topicListBean.getImageListThumb().get(0)).into(holder.mImage);
//        }else if (topicListBean.getImageListThumb()==null || topicListBean.getImageListThumb().get(position).length()==0){
////            Glide.with(context).load(topicListBean.getHeadImagePath()).into(holder.mImage);
////            Glide.with(context).load(topicListBean.getHeadImagePath()).into(holder.mImage2);
////            Glide.with(context).load(topicListBean.getHeadImagePath()).into(holder.mImage3);
////            Glide.with(context).load(R.drawable.wutu).into(holder.mImage);
////            Glide.with(context).load(R.drawable.wutu).into(holder.mImage2);
////            Glide.with(context).load(R.drawable.wutu).into(holder.mImage3);
//            holder.mImage.setImageResource(R.drawable.wutu);
//            holder.mImage2.setImageResource(R.drawable.wutu);
//            holder.mImage3.setImageResource(R.drawable.wutu);
//
//        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopicDetailsActivity.class);
                intent.putExtra("topicId",mList.get(position).getTopicId());
                intent.putExtra("userId",mList.get(position).getUserId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(String cursor, List<LoadTopicBean.TopicListBean> topicList) {
        mList.clear();
        mList.addAll(topicList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mIv1;
        private final TextView mName;
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mImage;
//        private final ImageView mImage2;
//        private final ImageView mImage3;
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
//            mImage2 = itemView.findViewById(R.id.topic_image2);
//            mImage3 = itemView.findViewById(R.id.topic_image3);
            mRead = itemView.findViewById(R.id.topic_read_number);
            mComment = itemView.findViewById(R.id.topic_comment_number);
            mLike = itemView.findViewById(R.id.topic_likes_number);
        }
    }
}
