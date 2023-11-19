package com.example.contactsmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class}, version = 1)
// entities -> point to the class that represents the table
// increase the version if you update the DB

// abstract class to prevent any possible creation in this class
public abstract class ContactDatabase extends RoomDatabase {
    //link the DB to the DAO
    public abstract ContactDAO getContactDao();

    //Singleton Pattern -> use singleton to ensure that only 1 instance
    // of the DB exists throughout the application's life
    // -> don't waste the memory

    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        // use synchronized to prevent any cleaning of the contract DB
        if (dbInstance == null) { // if there's no instance -> create a DB using databaseBuilder
            dbInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ContactDatabase.class,
                            "contacts_db"
                    ).fallbackToDestructiveMigration().build();
            //fallbackToDestructiveMigration: if entity have any change
                    // -> delete the existing Data (loose old data)
                    // -> create the new one
        }
        return dbInstance;
    }

}
