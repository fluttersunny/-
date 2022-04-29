package com.example.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private List<Item> itemList;

    public ItemListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final Item item = getItem(position);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        }
        else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
            holder.item_time = convertView.findViewById(R.id.item_time);
            holder.item_matter = convertView.findViewById(R.id.item_matter);
            holder.item_plan = convertView.findViewById(R.id.item_plan);
            holder.item_vertical_line = convertView.findViewById(R.id.item_vertical_line);
            holder.item_left_line = convertView.findViewById(R.id.item_left_line);
            holder.item_right_line = convertView.findViewById(R.id.item_right_line);
            convertView.setTag(holder);
        }
        if (item.getMatter().equals("")) holder.item_left_line.setVisibility(View.INVISIBLE);
        if (item.getPlan().equals("")) holder.item_right_line.setVisibility(View.INVISIBLE);
        holder.item_time.setText(item.getTime());
        holder.item_matter.setText(item.getMatter());
        holder.item_plan.setText(item.getPlan());
        return convertView;
    }

    static class ViewHolder {
        public TextView item_time,item_matter,item_plan;
        public ImageView item_vertical_line,item_left_line,item_right_line;
    }
}
