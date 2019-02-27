package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.brean.inform.SearchBean;

import java.util.List;

public class WenzhangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SearchBean.DataBean.NewListBean> list;
    Context context;
    OnClickListener onclicklistener;

    public void setOnclicklistener(OnClickListener onclicklistener) {
        this.onclicklistener = onclicklistener;
    }

    public WenzhangAdapter(List<SearchBean.DataBean.NewListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        if(viewType==1){
            view= LayoutInflater.from(context).inflate(R.layout.itme_informb,parent,false);
            holder=new Mywang2(view);
        }else{
            view= LayoutInflater.from(context).inflate(R.layout.itme_informd,parent,false);
            holder=new Mywang4(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==1){
            Mywang2 my2= (Mywang2) holder;
            my2.item2_text.setText(list.get(position).getTitle());
            my2.item2_text2.setText(list.get(position).getPublishTime());
            Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(my2.item2_image);
        }else{
            Mywang4 my4= (Mywang4) holder;
            my4.item4_text.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImageListThumb().get(0)).into(my4.item4_image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklistener.onclick(position,holder.itemView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Mywang2 extends RecyclerView.ViewHolder {
        TextView item2_text;
        TextView item2_text2;
        ImageView item2_image;

        public Mywang2(View itemView) {
            super(itemView);
            item2_text = itemView.findViewById(R.id.informb_title);
            item2_text2 = itemView.findViewById(R.id.informb_text);
            item2_image = itemView.findViewById(R.id.informb_image);
        }
    }

    class Mywang4 extends RecyclerView.ViewHolder {
        TextView item4_text;
        ImageView item4_image;

        public Mywang4(View itemView) {
            super(itemView);
            item4_text = itemView.findViewById(R.id.informd_title);
            item4_image = itemView.findViewById(R.id.informd_image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return 1;
        }else{
            return 0;
        }
    }

    public interface OnClickListener{
        void onclick(int i,View view);
    }
}
