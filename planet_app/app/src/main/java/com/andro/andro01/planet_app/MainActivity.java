package com.andro.andro01.planet_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        planetArrayList = new ArrayList<>();

        //create planets
        Planet earth = new Planet("Earth", "1 moon", R.drawable.earth);
        Planet mercury = new Planet("Mercury", "0 Moons", R.drawable.mercury);
        Planet venus = new Planet("Venus", "0 Moons", R.drawable.venus);

        Planet mars = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet jupiter = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet saturn = new Planet("Saturn", "83 Moons", R.drawable.saturn);

        Planet uranus = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet neptune = new Planet("Neptune", "14 Moons", R.drawable.neptune);

        //add to arrayList
        planetArrayList.add(earth);
        planetArrayList.add(mercury);
        planetArrayList.add(venus);

        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturn);

        planetArrayList.add(uranus);
        planetArrayList.add(neptune);

        adapter = new MyCustomAdapter(planetArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Planet name: " + adapter.getItem(i).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}