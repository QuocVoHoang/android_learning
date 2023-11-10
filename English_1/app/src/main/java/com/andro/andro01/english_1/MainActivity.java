package com.andro.andro01.english_1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button oneButton = findViewById(R.id.oneButton);
        Button redButton = findViewById(R.id.redButton);
        Button greenButton = findViewById(R.id.greenButton);
        Button blueButton = findViewById(R.id.blueButton);

//        oneButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(
//                        getApplicationContext(),
//                        R.raw.one
//                );
//                mediaPlayer.start();
//            }
//        });

        oneButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int clickedButtonId = view.getId();

        if (clickedButtonId == R.id.oneButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(
                    getApplicationContext(),
                    R.raw.one
            );
            mediaPlayer.start();
        } else if (clickedButtonId == R.id.redButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(
                    getApplicationContext(),
                    R.raw.red
            );
            mediaPlayer.start();
        } else if (clickedButtonId == R.id.greenButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(
                    getApplicationContext(),
                    R.raw.green
            );
            mediaPlayer.start();
        } else if (clickedButtonId == R.id.blueButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(
                    getApplicationContext(),
                    R.raw.blue
            );
            mediaPlayer.start();
        }
    }
}