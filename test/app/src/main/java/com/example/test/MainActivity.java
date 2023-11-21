package com.example.test;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding.setMyViewModel(myViewModel);

        binding.button.setOnClickListener(v -> {
            myViewModel.changeUser(new User("quoc", 22));
        });

        myViewModel.getUser().observe(this, user -> {
            binding.userName.setText(user.getUserName());
            binding.userAge.setText(String.valueOf(user.getUserAge()));
        });


    }
}