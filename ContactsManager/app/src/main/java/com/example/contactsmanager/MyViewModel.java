package com.example.contactsmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    // If you need to use context in inside you ViewModel
    // you should use AndroidViewModel (AVM)
    // because it contains the application context

    // AVM is a subclass of ViewModel
    // and similar to them, they're designed to store and
    // manage UI-related data are responsible to
    // prepare and provide data for UI automatically
    // allow data to survive configuration changes

    // Repository
    private Repository myRepository;

    // LiveData
    private LiveData<List<Contacts>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contacts) {
        myRepository.addNewContact(contacts);
    }

    public void deleteContact(Contacts contacts) {
        myRepository.deleteContact(contacts);
    }
}
