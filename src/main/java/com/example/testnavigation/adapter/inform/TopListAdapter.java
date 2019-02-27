package com.example.testnavigation.adapter.inform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testnavigation.R;

import java.util.List;

public class TopListAdapter extends BaseAdapter {
    Context context;
    List<String> list;
    private T t;
    public TopListAdapter(Context context, List<String> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.sousuo_item,parent,false);
            TextView text=convertView.findViewById(R.id.sousuo1);
            t = new T();
            t.text=text;
            convertView.setTag(t);
        }else{
            t= (T) convertView.getTag();
        }
        t.text.setText(list.get(position));
        return convertView;
    }
    public class T{
        TextView text;
    }
}
