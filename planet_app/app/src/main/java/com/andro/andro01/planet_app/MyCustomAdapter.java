package com.andro.andro01.planet_app;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    // used to hold the widgets in the an item (in listview)
    private static class MyViewHolder {
        TextView planetName;
        TextView moonCount;
        ImageView planetImage;
    }

    // getView(): to return the view for an item in the list
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1- get the planet object for the current position
        Planet planets = getItem(position);

        // 2- inflate layout
        MyViewHolder myViewHolder;
        final View result;

        //convertView is a recycled view that you can reuse to improve in your list
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);

            //finding views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moonCount);
            myViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.planetImage);

            result = convertView;

            //set tag method used to attach object to the view object
            convertView.setTag(myViewHolder);
        } else {
            // the view is recycled
            // get tag used to retrieve the object that set on the view object
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        //get the data from model class (Planet)
        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImage.setImageResource(planets.getPlanetImage());

        return result;
    }
}
