package com.andro.andro01.volume_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CylinderCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder_calculator);

        EditText cylinderRadius = findViewById(R.id.cylinderRadius);
        EditText cylinderHeight = findViewById(R.id.cylinderHeight);
        Button cylinderButton = findViewById(R.id.cylinderButton);
        TextView cylinderResult = findViewById(R.id.cylinderResult);

        cylinderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radius = Integer.parseInt(cylinderRadius.getText().toString());
                int height = Integer.parseInt(cylinderHeight.getText().toString());

                double cylinderVolume = 3.14 * radius * radius * height;
                cylinderResult.setText("Result: " + cylinderVolume);
            }
        });

    }
}