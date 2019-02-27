package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;
import com.example.testnavigation.activeity.DetailsActivity;
import com.example.testnavigation.brean.inform.DownListNews;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DownListNews.NewListBean> mDownListNews;

    public InformationAdapter(Context context, List<DownListNews.NewListBean> downListNews) {
        this.context = context;
        mDownListNews = downListNews;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%4==0){
            return 4;
        }else if (position%3==0){
            return 3;
        }else if (position%2==0){
            return 2;
        }else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        if (viewType == 1){
            View view= LayoutInflater.from(context).inflate(R.layout.itme_informa,parent,false);
            viewHolder=new ViewHoderA(view);
        }else if (viewType == 2){
            View view= LayoutInflater.from(context).inflate(R.layout.itme_informb,parent,false);
            viewHolder=new ViewHoderB(view);
        }else if (viewType == 3){
            View view= LayoutInflater.from(context).inflate(R.layout.itme_informc,parent,false);
            viewHolder=new ViewHoderC(view);
        }else {
            View view= LayoutInflater.from(context).inflate(R.layout.itme_informd,parent,false);
            viewHolder=new ViewHoderD(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        DownListNews.NewListBean newListBean = mDownListNews.get(position);
        if (holder instanceof ViewHoderA){
            ((ViewHoderA) holder).mTitlea.setText(newListBean.getTitle());
        }

        if (holder instanceof ViewHoderB){
            Glide.with(context).load(newListBean.getImageListThumb().get(0)).into(((ViewHoderB) holder).mInformb_image);
            ((ViewHoderB) holder).mTitleb.setText(newListBean.getTitle());
        }

        if (holder instanceof ViewHoderC){
            Glide.with(context).load(newListBean.getImageListThumb().get(0)).into(((ViewHoderC) holder).mInformc_image1);
            Glide.with(context).load(newListBean.getImageListThumb().get(0)).into(((ViewHoderC) holder).mInformc_image2);
            Glide.with(context).load(newListBean.getImageListThumb().get(0)).into(((ViewHoderC) holder).mInformc_image3);
            ((ViewHoderC) holder).mTitlec.setText(newListBean.getTitle());
        }

        if (holder instanceof ViewHoderD){
            Glide.with(context).load(newListBean.getImageListThumb().get(0)).into(((ViewHoderD) holder).mInformd_image);
            ((ViewHoderD) holder).mTitled.setText(newListBean.getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("newId",mDownListNews.get(position).getNewsId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDownListNews.size();
    }

    public void addData(int page, List<DownListNews.NewListBean> newListBeans) {
        if (page == 0){
            mDownListNews.clear();
        }
        mDownListNews.addAll(newListBeans);
        notifyDataSetChanged();
    }

    public class ViewHoderA extends RecyclerView.ViewHolder {

        private final TextView mTitlea;
        private final ImageView mTopa;

        public ViewHoderA(View itemView) {
            super(itemView);
            mTitlea = itemView.findViewById(R.id.informa_title);
            mTopa = itemView.findViewById(R.id.informa_top);
        }
    }

    public class ViewHoderB extends RecyclerView.ViewHolder {

        private final TextView mTitleb;
        private final ImageView mInformb_image;
        private final ImageView mTopb;
        private final ImageView mBxx;

        public ViewHoderB(View itemView) {
            super(itemView);
            mTitleb = itemView.findViewById(R.id.informb_title);
            mInformb_image = itemView.findViewById(R.id.informb_image);
            mTopb = itemView.findViewById(R.id.informb_top);
            mBxx = itemView.findViewById(R.id.informb_x);
        }
    }

    public class ViewHoderC extends RecyclerView.ViewHolder {

        private final TextView mTitlec;
        private final ImageView mInformc_image1;
        private final ImageView mInformc_image2;
        private final ImageView mInformc_image3;
        private final ImageView mTopc;
        private final ImageView mCxx;

        public ViewHoderC(View itemView) {
            super(itemView);
            mTitlec = itemView.findViewById(R.id.informc_title);
            mInformc_image1 = itemView.findViewById(R.id.informc_image1);
            mInformc_image2 = itemView.findViewById(R.id.informc_image2);
            mInformc_image3 = itemView.findViewById(R.id.informc_image3);
            mTopc = itemView.findViewById(R.id.informc_top);
            mCxx = itemView.findViewById(R.id.informc_x);
        }
    }

    public class ViewHoderD extends RecyclerView.ViewHolder {

        private final TextView mTitled;
        private final ImageView mInformd_image;
        private final ImageView mTopd;
        private final ImageView mDxx;

        public ViewHoderD(View itemView) {
            super(itemView);
            mTitled = itemView.findViewById(R.id.informd_title);
            mInformd_image = itemView.findViewById(R.id.informd_image);
            mTopd = itemView.findViewById(R.id.informd_top);
            mDxx = itemView.findViewById(R.id.informd_x);
        }
    }

}
