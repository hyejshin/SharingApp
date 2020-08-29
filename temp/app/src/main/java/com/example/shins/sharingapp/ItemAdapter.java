package com.example.shins.sharingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<Item> data;
    private int layout;

    public ItemAdapter(Context context, int layout, ArrayList<Item> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Item getItem(int position){
        return data.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = inflater.inflate(layout,parent,false);
        }

        Item item = data.get(position);

        Log.d("saveItem", "item" + item.getTitle() + item.getStatus() + item.getDescription());

        ImageView icon = convertView.findViewById(R.id.imageView);
        icon.setImageResource(item.getIcon());

        TextView title = convertView.findViewById(R.id.textTitle);
        title.setText(item.getTitle());

        TextView status = convertView.findViewById(R.id.textStatus);
        status.setText(item.getStatus());

        TextView description = convertView.findViewById(R.id.textDescription);
        description.setText(item.getDescription());

        return convertView;
    }
}
