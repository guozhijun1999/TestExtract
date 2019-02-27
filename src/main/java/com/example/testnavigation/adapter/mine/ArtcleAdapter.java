package com.example.testnavigation.adapter.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.activeity.mine.CollectActivity;
import com.example.testnavigation.brean.mine.FavouriteNewsBean;

import java.util.List;
import java.util.Map;

public class ArtcleAdapter extends RecyclerView.Adapter<ArtcleAdapter.ViewHolder> {
    private Context mContext;
    private List<FavouriteNewsBean.FavouritNewsListBean> mData;
    private ViewHolder mViewHolder;
    public Map<Integer,Boolean> map;

    public ArtcleAdapter(Context context, List<FavouriteNewsBean.FavouritNewsListBean> data, Map<Integer, Boolean> map) {
        mContext = context;
        mData = data;
        this.map = map;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_mine_artcle,parent,false);
        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mTitle.setText(mData.get(position).getTitle());
        if (CollectActivity.biaoji==1){
            holder.mSelect.setVisibility(View.VISIBLE);
        }else if (CollectActivity.biaoji==0){
            holder.mSelect.setVisibility(View.GONE);
        }

        if(map.get(position)){
            holder.mSelect.setImageResource(R.mipmap.collect_select);
        }else{
            holder.mSelect.setImageResource(R.mipmap.collect_selects);
        }
        holder.mSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItmeClickArtcle.onDianji(position,holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTitle;
        public final ImageView mSelect;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mSelect = itemView.findViewById(R.id.collect_select);
        }
    }
    private OnItmeClickArtcle mOnItmeClickArtcle;

    public void setOnItmeClickArtcle(OnItmeClickArtcle onItmeClickArtcle) {
        mOnItmeClickArtcle = onItmeClickArtcle;
    }

    public interface OnItmeClickArtcle{
        void onDianji(int position,ArtcleAdapter.ViewHolder viewHolder);
    }
}
