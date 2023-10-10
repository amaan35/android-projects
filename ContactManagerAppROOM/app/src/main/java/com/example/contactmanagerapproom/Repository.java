package com.example.contactmanagerapproom;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.contactmanagerapproom.db.ContactDAO;
import com.example.contactmanagerapproom.db.ContactsDatabase;
import com.example.contactmanagerapproom.db.entity.Contact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    //Available data sources
    //Room DB
    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {
        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactDAO = contactsDatabase.getContactDAO();
        //used for background database operations
         executor = Executors.newSingleThreadExecutor();
        //used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    //methods in DAO being executed from repository
    public void addContact(Contact contact){
        //Runnable : executing task on separate thread
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //execute this code asynchronously
                //on separate thread
                contactDAO.insert(contact);
            }
        });
    }
    public void deleteContact(Contact contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }
    public LiveData<List<Contact>> getAllContacts(){
        return contactDAO.getAllContacts();
    }
}
