package com.example.testnavigation.adapter.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.mine.UserListCommentBean;

import java.util.List;

public class CommentAdapter1 extends RecyclerView.Adapter<CommentAdapter1.ViewHolder> {
    private List<UserListCommentBean.UserCommentListBean> mData;
    private Context mContext;

    public CommentAdapter1(List<UserListCommentBean.UserCommentListBean> data, Context context) {
        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_comment_1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTime.setText(mData.get(position).getCommentTime());
        holder.mTitle.setText(mData.get(position).getTitle()+"");
        holder.mShare.setText(mData.get(position).getContent());

        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(mData.get(position));
                Toast.makeText(mContext,"已删除",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mTime;
        private final TextView mTitle;
        private final TextView mDelete;
        private final TextView mShare;
        private final TextView mComment;
        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.name);
            mTime = itemView.findViewById(R.id.time);
            mTitle = itemView.findViewById(R.id.title);
            mDelete = itemView.findViewById(R.id.delete);
            mShare = itemView.findViewById(R.id.share);
            mComment = itemView.findViewById(R.id.comment);
        }
    }
}
