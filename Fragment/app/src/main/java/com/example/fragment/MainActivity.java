package com.example.fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        loadFragment(new FirstFragment());

        btn1.setOnClickListener(view -> {
            loadFragment(new FirstFragment());
        });
        btn2.setOnClickListener(view -> {
            loadFragment(new SecondFragment());
        });
    }

    void loadFragment(Fragment fragment){
        //responsible for all runtimes management of fragment
        //including adding, removing, hiding, showing
        //and navigating between fragment
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        //replace the framelayout with the fragment
        ft.replace(R.id.frameLayout, fragment).commit();
    }
}