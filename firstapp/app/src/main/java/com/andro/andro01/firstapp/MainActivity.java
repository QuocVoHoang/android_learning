package com.andro.andro01.firstapp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigateButton = findViewById(R.id.navigateToSecondPage);

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTosecondPage();

            }
        });


    }

    void navigateTosecondPage() {
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }
}