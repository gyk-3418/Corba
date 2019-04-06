package com.example.corba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    public ArrayList<Category> itemList = new ArrayList<>();
    public Context context;

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(
                context, R.layout.menu_list_item, null);

        ImageView imageViewIcon = view.findViewById(R.id.img_icon);
        TextView textViewTitle = view.findViewById(R.id.txtVwTitle);

        Category currentItem = itemList.get(position);

        textViewTitle.setText(currentItem.title);
        if(currentItem.icon != 0)
        {
            imageViewIcon.setImageResource(currentItem.icon);
        }

        return view;
    }
}
