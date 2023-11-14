package com.andro.andro01.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Sport> sportArrayList;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportArrayList = new ArrayList<>();

        Sport s1 = new Sport("Football", R.drawable.football);
        Sport s2 = new Sport("Basketball", R.drawable.basketball);
        Sport s3 = new Sport("VolleyBall", R.drawable.volley);
        Sport s4 = new Sport("Tennis", R.drawable.tennis);
        Sport s5 = new Sport("Ping Pong", R.drawable.ping);
        sportArrayList.add(s1);
        sportArrayList.add(s2);
        sportArrayList.add(s3);
        sportArrayList.add(s4);
        sportArrayList.add(s5);

        customAdapter = new CustomAdapter(sportArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }
}