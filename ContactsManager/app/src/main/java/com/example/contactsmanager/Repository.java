package com.example.contactsmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {
    // The available Data sources:
    // - RoomDB

    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDao();

        // Used for Background Database Operations
        executor = Executors.newSingleThreadExecutor();

        // Used for updating the UI
        handler = new Handler(Looper.getMainLooper()); // handler in android.os
    }

    // methods in DAO being executed from Repository
    public void addNewContact(Contacts contact) {
        // Runnable to run task on synchronously
        // commonly used with thread related to the APIs
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts() {
        return contactDAO.getAllContacts();
        // don't use async because Run doesn't return anything
        // we public the List on the UI (Run on the background)
        // => use the LiveData
    }

}
