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
import com.bumptech.glide.request.RequestOptions;
import com.example.testnavigation.R;
import com.example.testnavigation.brean.topic.SousuoinfoBean;

import java.util.List;

public class SousuoInfoAdapter extends RecyclerView.Adapter<SousuoInfoAdapter.ViewHolder> {
    Context context;
    List<SousuoinfoBean.DataBean.TopicListBean> list;

    public SousuoInfoAdapter(Context context, List<SousuoinfoBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sousuoinfo_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getHeadImagePath()).apply(options).into(holder.head);

        holder.name.setText(list.get(position).getNickname());
        holder.tim.setText(list.get(position).getPublishTime());
        holder.text.setText(list.get(position).getTitle());


        if (list.get(position).getImageListThumb() != null) {
            if (list.get(position).getImageListThumb().size()== 1) {
                Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(holder.image1);
            }
            if (list.get(position).getImageListThumb().size()==2) {
                Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(holder.image1);
                Glide.with(context).load(list.get(position).getImageListThumb().get(1)).into(holder.image2);
            }
            if (list.get(position).getImageListThumb().size()==3) {
                Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(holder.image1);
                Glide.with(context).load(list.get(position).getImageListThumb().get(1)).into(holder.image2);
                Glide.with(context).load(list.get(position).getImageListThumb().get(2)).into(holder.image3);
            }
        }

        holder.yuedu.setText(list.get(position).getPageviews() + "");
        holder.dianzan.setText(list.get(position).getLikes() + "");
        holder.pinglun.setText(list.get(position).getComments() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<SousuoinfoBean.DataBean.TopicListBean> topicList) {
        list.clear();
        list.addAll(topicList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView head;
        TextView name;
        TextView tim;
        TextView text;
        TextView yuedu;
        TextView pinglun;
        TextView dianzan;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        public ViewHolder(View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.sousuoinfo_head);
            name = itemView.findViewById(R.id.sousuoinfo_name);
            tim = itemView.findViewById(R.id.sousuoinfo_tim);
            text = itemView.findViewById(R.id.sousuoinfo_context);
            image1 = itemView.findViewById(R.id.sousuoinfo_image11);
            image2 = itemView.findViewById(R.id.sousuoinfo_image22);
            image3 = itemView.findViewById(R.id.sousuoinfo_image33);
            yuedu = itemView.findViewById(R.id.sousuoinfo_yuedu);
            pinglun = itemView.findViewById(R.id.sousuoinfo_pinglun);
            dianzan = itemView.findViewById(R.id.sousuoinfo_dianzan);
        }
    }
}
