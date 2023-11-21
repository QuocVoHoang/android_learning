package com.example.test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<User> user = new MutableLiveData<>();

    public MutableLiveData<User> getUser() {
        if (user.getValue() == null) {
            user.setValue(new User("null", 0));
        }
        return user;
    }

    public void changeUser(User newUser) {
        user.setValue(newUser);
    }
}
