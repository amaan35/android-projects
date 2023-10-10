package com.example.contactmanagerapproom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.contactmanagerapproom.db.entity.Contact;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Contact>> allContacts;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }
    public LiveData<List<Contact>> getAllContacts(){
        allContacts = repository.getAllContacts();
        return allContacts;
    }
    public void addNewContact(Contact contact){
        repository.addContact(contact);
    }
    public void deleteContact(Contact contact){
        repository.deleteContact(contact);
    }
}
