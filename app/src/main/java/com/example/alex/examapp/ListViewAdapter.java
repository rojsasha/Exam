package com.example.alex.examapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter
{
    ArrayList<String > mList;

    public ListViewAdapter(@NonNull Context context, ArrayList<String> list) {
        super(context, 0, list);
        mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);


        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = mList.get(position);
        holder.mTextView.setText(s);

        return convertView;
    }

    class ViewHolder{
        TextView mTextView;
        ViewHolder(View view){
            mTextView = view.findViewById(R.id.itemText);

        }
    }
}
