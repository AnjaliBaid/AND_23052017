package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anju on 29/5/17.
 */

public  class Myadapter extends BaseAdapter {

    private final Context context;
    private  final List<Myitem> data;
    private final LayoutInflater inflater;

    public Myadapter(Context context,List<Myitem> data){

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //View view1 = inflater.inflate(R.layout.linear,parent,false);
        View view = null;
        if (convertView==null)
            view =inflater.inflate(R.layout.linear,parent,false);
        else view =convertView;

        ((ImageView)view.findViewById(R.id.img)).setImageResource(data.get(position).imgid);
        ((TextView)view.findViewById(R.id.txt)).setText(data.get(position).text);
        return view;
    }
}
