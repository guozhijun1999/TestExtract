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
import com.example.testnavigation.brean.mine.FavouriteTopicBean;

import java.util.List;

public class Topicadapter extends RecyclerView.Adapter<Topicadapter.ViewHolder> {
    private Context mContext;
    private List<FavouriteTopicBean.FavouritTopicListBean> mData;

    public Topicadapter(Context context, List<FavouriteTopicBean.FavouritTopicListBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_topicone,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> imageListThumb = (List<String>) mData.get(position).getImageListThumb();
        if(imageListThumb!=null){
            holder.mName.setText(mData.get(position).getNickname()+"");
            holder.mTime.setText(mData.get(position).getPublishTime()+"");
            holder.mTitle.setText(mData.get(position).getTitle()+"");
            holder.mComment.setText(mData.get(position).getComment()+"");
            Glide.with(mContext).load(mData.get(position).getHeadImagePath()).into(holder.mImage);
            if(imageListThumb.size()==3){
                Glide.with(mContext).load(imageListThumb.get(0)).into(holder.mImage1);
                Glide.with(mContext).load(imageListThumb.get(1)).into(holder.mImage2);
                Glide.with(mContext).load(imageListThumb.get(2)).into(holder.mImage3);
            }else if(imageListThumb.size()==2){
                Glide.with(mContext).load(imageListThumb.get(0)).into(holder.mImage1);
                Glide.with(mContext).load(imageListThumb.get(1)).into(holder.mImage2);
            }else{
                Glide.with(mContext).load(imageListThumb.get(0)).into(holder.mImage1);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mTime;
        private final TextView mTitle;
        private final TextView mComment;
        private final ImageView mImage;
        private final ImageView mImage1;
        private final ImageView mImage2;
        private final ImageView mImage3;
        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.item_image);
            mImage1 = itemView.findViewById(R.id.item_image_1);
            mImage2 = itemView.findViewById(R.id.item_image_2);
            mImage3 = itemView.findViewById(R.id.item_image_3);
            mName = itemView.findViewById(R.id.item_name);
            mTime = itemView.findViewById(R.id.item_time);
            mTitle = itemView.findViewById(R.id.item_title);
            mComment = itemView.findViewById(R.id.item_comment);
        }
    }
}
