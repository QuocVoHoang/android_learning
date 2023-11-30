package com.example.pagingapp.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.RequestManager;
import com.example.pagingapp.R;
import com.example.pagingapp.adapter.MovieAdapter;
import com.example.pagingapp.adapter.MovieLoadStateAdapter;
import com.example.pagingapp.databinding.ActivityMainBinding;
import com.example.pagingapp.util.GridSpace;
import com.example.pagingapp.util.MovieComparator;
import com.example.pagingapp.util.Utils;
import com.example.pagingapp.viewmodel.MovieViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    MovieViewModel mainActivityViewModel;
    ActivityMainBinding binding;
    MovieAdapter movieAdapter;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        if (Utils.API_KEY == null || Utils.API_KEY.isEmpty()) {
            Toast.makeText(this, "Error: API KEY is empty", Toast.LENGTH_SHORT).show();
        }

        movieAdapter = new MovieAdapter(new MovieComparator(), requestManager);

        mainActivityViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        initRecyclerViewAdapter();

        // subscribe to paging data
        mainActivityViewModel.moviePagingDataFlowable.subscribe(moviePagingData -> {
            movieAdapter.submitData(getLifecycle(), moviePagingData);
        });
    }

    private void initRecyclerViewAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        binding.recyclerView.addItemDecoration(new GridSpace(2,20,true));

        binding.recyclerView.setAdapter(
                movieAdapter.withLoadStateFooter(
                        new MovieLoadStateAdapter(view -> {
                            movieAdapter.retry();
                        })
                )
        );

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return movieAdapter.getItemViewType(position) == MovieAdapter.LOADING_ITEM ? 1:2;
            }
        });
    }
}