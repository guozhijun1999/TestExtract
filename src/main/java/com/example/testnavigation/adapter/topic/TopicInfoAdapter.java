package com.example.testnavigation.adapter.topic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.brean.topic.TopicDetailsBean;

import java.util.List;

public class TopicInfoAdapter extends RecyclerView.Adapter<TopicInfoAdapter.ViewHolder> {
    Context context;
    List<String> list;

    public TopicInfoAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_infoitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = list.get(position);
//        if (topicDetailsBean.getImageListThumb().size()==3) {
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(0)).into(holder.image);
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(1)).into(holder.image2);
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(2)).into(holder.image3);
//        } else if (topicDetailsBean.getImageListThumb().size()==2){
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(0)).into(holder.image);
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(1)).into(holder.image2);
//        }else if (topicDetailsBean.getImageListThumb().size()==1) {
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(0)).into(holder.image);
//        }else if (topicDetailsBean.getImageListThumb().size()==0){
//            Glide.with(context).load(topicDetailsBean.getImageListThumb().get(0)).into(holder.image);
//        }
        Glide.with(context).load(s.toString()).into(holder.image);
        Log.e("1qerfds",s.toString());
//        Log.e("RSGFADG",topicDetailsBean.getImageListThumb().size()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView image2;
        ImageView image3;
        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.infoimage);
//            image2=itemView.findViewById(R.id.infoimage2);
//            image3=itemView.findViewById(R.id.infoimage3);
        }
    }
}
