package com.andro.andro01.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Person> personArrayList;

    public PersonAdapter(Context context, ArrayList<Person> personArrayList) {
        super(context, R.layout.item_layout, personArrayList);
        this.context = context;
        this.personArrayList = personArrayList;
    }

    public static class MyViewHolder {
        TextView personName;
        TextView personAge;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person person = (Person) getItem(position);
        MyViewHolder myViewHolder;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_layout, parent, false);

            myViewHolder.personName = convertView.findViewById(R.id.personName);
            myViewHolder.personAge = convertView.findViewById(R.id.personAge);

            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.personName.setText(person.getName());
        myViewHolder.personAge.setText("YO: " + person.getAge());
        return convertView;
    }
}
