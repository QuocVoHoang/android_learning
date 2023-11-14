package com.andro.andro01.volume_calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {
    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    public static class MyViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1 - get the shape object for the current position
        Shape shapes = getItem(position);

        //2 - inflating the layout
        MyViewHolder myViewHolder;

        if (convertView == null) {
            // if view went off-screen -> create a new view
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);

            // finding views
            myViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.textView = (TextView) convertView.findViewById(R.id.textView);

            //set tag method used to attach object to the view object
            convertView.setTag(myViewHolder);
        } else {
            // the view is recycled
            // get tag used to retrieve the object that set on the view object
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        //get the data from model class (Shape)
        myViewHolder.imageView.setImageResource(shapes.getShapeImg());
        myViewHolder.textView.setText(shapes.getShapeName());


        return convertView;
    }
}
