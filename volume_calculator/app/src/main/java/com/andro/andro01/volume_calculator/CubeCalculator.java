package com.andro.andro01.volume_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CubeCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube_calculator);

        TextView cubeResult = findViewById(R.id.cubeResult);
        EditText cubeLength = findViewById(R.id.cubeLength);
        EditText cubeWidth = findViewById(R.id.cubeWidth);
        EditText cubeHeight = findViewById(R.id.cubeHeight);
        Button cubeButton = findViewById(R.id.cubeButton);

        cubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                int cubeVolume = 0;
                int length = Integer.parseInt(cubeLength.getText().toString());
                int width = Integer.parseInt(cubeWidth.getText().toString());
                int height = Integer.parseInt(cubeHeight.getText().toString());

                cubeVolume = length * width * height;
                cubeResult.setText("Result: " + cubeVolume);
            }
        });
    }
}