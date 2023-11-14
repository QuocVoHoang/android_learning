package com.andro.andro01.cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<Sport> sportArrayList;

    public CustomAdapter(ArrayList<Sport> sportArrayList) {
        this.sportArrayList = sportArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCard;
        TextView textViewCard;

        public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCard = itemView.findViewById(R.id.imageViewCard);
            textViewCard = itemView.findViewById(R.id.textViewCard);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_item_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sport sport = sportArrayList.get(position);
        holder.imageViewCard.setImageResource(sport.getSportImg());
        holder.textViewCard.setText(sport.getSportName());
    }

    @Override
    public int getItemCount() {
        return sportArrayList.size();
    }
}
