package com.example.testnavigation.adapter.topic;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.testnavigation.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.POST;

public class FaImageAdapter extends RecyclerView.Adapter<FaImageAdapter.ViewHolder> {
    Context context;
    List<String> mList;

    public FaImageAdapter(Context context, List<String> list) {
        this.context = context;
        mList = list;
    }

    @NonNull
    @Override
    public FaImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_imageitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FaImageAdapter.ViewHolder holder, final int position) {
        holder.image1.setImageResource(R.mipmap.release_add);
        if (mList.get(position).equals("haha")) {
            holder.image1.setVisibility(View.VISIBLE);
        }else{
            holder.image1.setVisibility(View.GONE);
        }


        if (mList.get(position).equals("storage")) {
            File file = new File(mList.get(position));
            //将bitmap转化成drawable
            try {
                Bitmap bmp = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.fromFile(file));
                holder.image.setImageBitmap(bmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Glide.with(context).load(mList.get(position)).into(holder.image);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onclicks(position);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnLongClickListener.onclicklongs(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView image1;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fabu_imageadd);
            image1 = itemView.findViewById(R.id.fabu_imageadd1);
        }
    }
    private OnClickListener mOnClickListener;
    private OnLongClickListener mOnLongClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

    public interface OnClickListener {
        void onclicks(int position);
    }

    public interface OnLongClickListener {
        void onclicklongs(int position);
    }
}
