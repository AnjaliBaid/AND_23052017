package com.example.external_storage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anju on 19/6/17.
 */

public class File_Adapter extends BaseAdapter {

    private final Context context;
    private final List<File_item> data;
    private LayoutInflater inflater;

    public File_Adapter(Context context,List<File_item> data){

        this.context=context;
        this.data=data;
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

        View view = null;

        if (convertView == null){
            view = inflater.inflate(R.layout.linear,parent,false);
        }
        else
            view = convertView;

        ((ImageView) view.findViewById(R.id.img)).setImageResource(data.get(position).ic);
        ((TextView) view.findViewById(R.id.txtNm)).setText(data.get(position).nm);
        ((TextView) view.findViewById(R.id.txtMdfd)).setText(data.get(position).mdfd);
        ((TextView) view.findViewById(R.id.txtsz)).setText(data.get(position).sz);

        return view;
    }
}
