package com.andro.andro01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private final Context context;
    private final String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length; // returns the number of items in data source
    }

    @Override
    public Object getItem(int position) {
        return items[position]; // returns the data item at given position
    }

    @Override
    public long getItemId(int itemId) {
        return itemId;  // return item id at the position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //convertView is a recycled view that you can reuse to improve in your list
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item1, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.listItemText);
            convertView.setTag(viewHolder);
        } else {
            // reusing the view (that's recycled)
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(items[position]);
        return convertView; // display the data at a position in the data set
    }

    static class ViewHolder {
        TextView textView;
    }
}
