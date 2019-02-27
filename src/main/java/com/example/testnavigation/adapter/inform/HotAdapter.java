package com.example.testnavigation.adapter.inform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testnavigation.R;
import com.example.testnavigation.brean.inform.HotBean;

import java.util.List;

public class HotAdapter extends BaseAdapter {
    Context context;
    List<HotBean.DataBean.SearchListBean> list;
    private T t;

    public HotAdapter(Context context, List<HotBean.DataBean.SearchListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.hot_item,parent,false);
            TextView text=convertView.findViewById(R.id.hot);
            TextView num=convertView.findViewById(R.id.num);
            t = new T();
            t.text=text;
            t.num=num;
            convertView.setTag(t);
        }else{
            t= (T) convertView.getTag();
        }
        t.text.setText(list.get(position).getContent());
        if(position==0){
            t.num.setTextColor(Color.parseColor("#E06A2D"));
            t.num.setText((position+1)+".");
        }else if(position==1){
            t.num.setTextColor(Color.parseColor("#FA894D"));
            t.num.setText((position+1)+".");
        }else if(position==2){
            t.num.setTextColor(Color.parseColor("#FBB33C"));
            t.num.setText((position+1)+".");
        }else if(position==3){

            t.num.setTextColor(Color.parseColor("#ACACAC"));
            t.num.setText((position+1)+".");
        }else if(position==4){
            t.num.setTextColor(Color.parseColor("#ACACAC"));
            t.num.setText((position+1)+".");
        }
        // Log.i("===============", "getView: "+list.get(position).getSearchList().get(position).getContent());
        return convertView;
    }
    class T{
        TextView text;
        TextView num;
    }
}
