package com.andro.andro01.testapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Person> personArrayList;
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        personArrayList = new ArrayList<>();
        personArrayList.add(new Person("quoc000000", 22));
        personArrayList.add(new Person("quoc1", 23));
        personArrayList.add(new Person("quoc2", 24));
        personArrayList.add(new Person("quoc3", 25));
        personArrayList.add(new Person("quoc", 22));
        personArrayList.add(new Person("quoc1", 23));
        personArrayList.add(new Person("quoc2", 24));
        personArrayList.add(new Person("quoc3", 25));
        personArrayList.add(new Person("quoc", 22));
        personArrayList.add(new Person("quoc1", 23));
        personArrayList.add(new Person("quoc2", 24));
        personArrayList.add(new Person("quoc3", 25));
        personArrayList.add(new Person("quoc", 22));
        personArrayList.add(new Person("quoc1", 23));
        personArrayList.add(new Person("quoc2", 24));
        personArrayList.add(new Person("quoc3", 25));

        personAdapter = new PersonAdapter(getApplicationContext(), personArrayList);
        listView.setAdapter(personAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = (Person) personAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        person.getName() + " : " + person.getAge(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}