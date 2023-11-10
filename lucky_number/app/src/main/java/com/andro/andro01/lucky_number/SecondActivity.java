package com.andro.andro01.lucky_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView userNameTxt = findViewById(R.id.userName);
        TextView luckyNumberTxt = findViewById(R.id.luckyNumber);
        Button shareButton = findViewById(R.id.shareButton);

        Intent intent = getIntent();
        String getUserName = intent.getStringExtra("userName");
        userNameTxt.setText(getUserName);

        int luckyNumber = getLuckyNumber();
        luckyNumberTxt.setText(String.valueOf(luckyNumber));

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(getUserName, luckyNumber);
            }
        });
    }

    public int getLuckyNumber() {
        Random random = new Random();
        int upperLimit = 999;
        int randomNumberGenerated = random.nextInt(upperLimit);
        return randomNumberGenerated;
    }

    public void shareData(String userName, int luckyNumber) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName + "got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "HIS LUCKY NUMBER IS: " + luckyNumber);

        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}