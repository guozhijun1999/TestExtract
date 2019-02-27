package com.example.testnavigation.adapter.mine;

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

public class Moreadapter3 extends RecyclerView.Adapter<Moreadapter3.ViewHolder> {
    private Context context;
    public List<TagsSearchBean.TagListBean> mList;
    private int thisPosition;
    private Moreadapter1.OnItemClick mOnItemClick;

    public int getthisPosition() {
        return thisPosition;
    }

    public Moreadapter3(Context context, List<TagsSearchBean.TagListBean> list, int thisPosition) {
        this.context = context;
        mList = list;
        this.thisPosition = thisPosition;
    }

    @NonNull
    @Override
    public Moreadapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_more_1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Moreadapter3.ViewHolder holder, final int position) {
        if (position == getthisPosition()) {
//            holder1.mTitle.setBackgroundColor(Color.GRAY);
            holder.mTitle.setBackgroundResource(R.color.bg_focus2);
        } else {
            holder.mTitle.setBackgroundResource(R.color.colorWhite);
        }
        holder.mTitle.setText(mList.get(position).getTag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClick!=null){
                    mOnItemClick.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
        }
    }

    public interface OnItemClick{
        void onItemClick(View v,int position);
    }
    public void setOnItemClick(Moreadapter1.OnItemClick onItemClick){
        mOnItemClick = onItemClick;
    }
}
