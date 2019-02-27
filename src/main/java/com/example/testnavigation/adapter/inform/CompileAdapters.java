package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.greend.MyChannelDao;

import java.util.List;

public class CompileAdapters extends RecyclerView.Adapter<CompileAdapters.ViewHolder>{
    private Context mContext;
    public List<MyChannelDao> mData;
    public boolean isshow=false;
    public CompileAdapters(Context context, List<MyChannelDao> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public CompileAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.itme_compile,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompileAdapters.ViewHolder holder, final int position) {
        MyChannelDao myChannelDao = mData.get(position);
        holder.mTv.setText(myChannelDao.getChannelName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ItemClick!=null){
                    ItemClick.onItemClick(v,position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTv;
        private final ImageView mClose;
        public ViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_Compile);
            mClose = itemView.findViewById(R.id.close_comp);
        }
    }
    private OnItemClick ItemClick;

    public interface OnItemClick{
        void onItemClick(View view,int position);
    }
    public void setOnItemClick(OnItemClick itemClick){
        this.ItemClick=itemClick;
    }
}
