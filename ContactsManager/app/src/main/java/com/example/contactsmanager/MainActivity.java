package com.example.contactsmanager;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //data source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //adapter
    private MyAdapter myAdapter;

    //binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clickHandler = new MainActivityClickHandler(this);
        mainBinding.setClickHandler(clickHandler);

        //recycler view
        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        //database
        contactDatabase = ContactDatabase.getInstance(this);


        //view model
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //insert a new contact (just for testing)
//        Contacts c1 = new Contacts("quoc", "quoc@gmail.com");
//        viewModel.addNewContact(c1);

        // loading the data from RoomDB
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for (Contacts c : contacts) {
                    Log.v("TAGY", c.getName());
                    contactsArrayList.add(c);
                }
                //to display data from logcat into recycler view
                myAdapter.notifyDataSetChanged();
            }
        });

        //adapter
        myAdapter = new MyAdapter(contactsArrayList);

        //linking the recycler view with the adapter
        recyclerView.setAdapter(myAdapter);

        // swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                viewModel.deleteContact(contactsArrayList.get(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);

    }
}