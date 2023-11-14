package com.andro.andro01.volume_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Shape> arrayList;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        arrayList = new ArrayList<>();

        Shape cube = new Shape(R.drawable.cube, "cube");
        Shape cylinder = new Shape(R.drawable.cylinder, "cylinder");
        Shape prism = new Shape(R.drawable.prism, "prism");
        Shape sphere = new Shape(R.drawable.sphere, "sphere");

        arrayList.add(cube);
        arrayList.add(cylinder);
        arrayList.add(prism);
        arrayList.add(sphere);

        adapter = new MyCustomAdapter(arrayList, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        "Name: " + item.getShapeName(),
                        Toast.LENGTH_SHORT).show();

                if (item == cube) {
                    Intent intent = new Intent(getApplicationContext(), CubeCalculator.class);
                    startActivity(intent);
                }
                if (item == cylinder) {
                    Intent intent = new Intent(getApplicationContext(), CylinderCalculator.class);
                    startActivity(intent);
                }

            }
        });
    }
}