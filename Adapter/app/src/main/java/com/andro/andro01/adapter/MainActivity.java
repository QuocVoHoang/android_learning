package com.andro.andro01.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        String[] countries = {"VIETNAM", "USA", "USB"};

        MyCustomAdapter adapter = new MyCustomAdapter(this, countries);

        listView.setAdapter(adapter);
    }
}