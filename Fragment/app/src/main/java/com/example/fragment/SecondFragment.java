package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        Button button = view.findViewById(R.id.secondFragmentButton);
        TextView textView = view.findViewById(R.id.secondFragmentTextView);

        button.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "GOOD BYE from Fragment", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}