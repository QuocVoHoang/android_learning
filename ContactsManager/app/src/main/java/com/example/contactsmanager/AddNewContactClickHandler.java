package com.example.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class AddNewContactClickHandler {
    Contacts contact;
    Context context;

    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contact, Context context, MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitButtonClicked(View view){
        if(contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
//            intent.putExtra("Name", contacts.getName());
//            intent.putExtra("Email", contacts.getEmail());

            Contacts c = new Contacts(contact.getName(), contact.getEmail());

            myViewModel.addNewContact(c);

            context.startActivity(intent);
        }
    }
}
