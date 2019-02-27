package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.CompileActivity;
import com.example.testnavigation.brean.greend.MyChannelDao;

import java.util.List;

public class CompileAdapter extends RecyclerView.Adapter<CompileAdapter.ViewHolder> {
    public  List<MyChannelDao> mData;
    private Context mContext;
    public boolean isshow=false;
    public CompileAdapter(List<MyChannelDao> data, Context context) {
        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public CompileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.itme_compile,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompileAdapter.ViewHolder holder, final int position) {
        MyChannelDao myChannelDao = mData.get(position);
        holder.mTv.setText(myChannelDao.getChannelName());
        holder.mRlclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ItemClick!=null){
                    ItemClick.onItemClick(v,position);
                }
            }
        });


        if (isshow) {
            if(position==0){
                holder.mTv.setEnabled(false);
                holder.mClose.setVisibility(View.GONE);
            }else{
                holder.mClose.setVisibility(View.VISIBLE);
            }
        } else {
            holder.mClose.setVisibility(View.GONE);
        }

//        if (CompileActivity.a==1){
//            holder.mClose.setVisibility(View.VISIBLE);
//        }
//        if(CompileActivity.a==0){
//            holder.mClose.setVisibility(View.GONE);
//        }
//        if (position ==0){
//            holder.mClose.setVisibility(View.GONE);
//        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv;
        private final ImageView mClose;
        private final RelativeLayout mRlclose;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_Compile);
            mClose = itemView.findViewById(R.id.close_comp);
            mRlclose = itemView.findViewById(R.id.rl_close);
        }
    }
    private  OnItemClick ItemClick;
    public interface OnItemClick{
        void onItemClick(View view,int position);
    }
    public  void setOnItemClick(OnItemClick itemClick){
        ItemClick=itemClick;
    }
}
