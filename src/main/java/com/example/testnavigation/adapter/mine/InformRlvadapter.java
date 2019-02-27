package com.example.testnavigation.adapter.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.mine.ListNotifyBean;
import com.example.testnavigation.view.QQBezierView;

import java.util.List;

public class InformRlvadapter extends RecyclerView.Adapter<InformRlvadapter.ViewHolder> {
    private Context mContext;
    public List<ListNotifyBean.DataBean> mData;

    public InformRlvadapter(Context context, List<ListNotifyBean.DataBean> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_inform, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//holder1.mTitle.setText(mData.get(position).getNotifyTitle());
        holder.mTime.setText(mData.get(position).getNotifyTime());

        /*holder1.tv_to_unread.setVisibility(position  != 0 ? View.VISIBLE : View.GONE);
        holder1.tv_to_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder1.swipe_menu.isMenuOpen()) {
                    holder1.swipe_menu.smoothToCloseMenu();
                }
                Toast.makeText(mContext, "置顶", Toast.LENGTH_SHORT).show();
            }
        });
        holder1.tv_to_unread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder1.swipe_menu.isMenuOpen()) {
                    holder1.swipe_menu.smoothToCloseMenu();
                }
                Toast.makeText(mContext, "标为未读", Toast.LENGTH_SHORT).show();
            }
        });
        holder1.tv_to_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder1.swipe_menu.isMenuOpen()) {
                    holder1.swipe_menu.smoothToCloseMenu();
                }
                Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
            }
        });
        holder1.swipe_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "这是第" + (position + 1) + "条数据", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_to_top, tv_to_unread, tv_to_delete;
        private final TextView mTime;
        private com.example.testnavigation.view.SwipeMenuLayout swipe_menu;
        private QQBezierView qq_point;

        public ViewHolder(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.time);
            qq_point = (QQBezierView) itemView.findViewById(R.id.qq_point);
            swipe_menu = (com.example.testnavigation.view.SwipeMenuLayout) itemView.findViewById(R.id.swipe_menu);
            tv_to_top = (TextView) itemView.findViewById(R.id.tv_to_top);
            tv_to_unread = (TextView) itemView.findViewById(R.id.tv_to_unread);
            tv_to_delete = (TextView) itemView.findViewById(R.id.tv_to_delete);
        }
    }
}
