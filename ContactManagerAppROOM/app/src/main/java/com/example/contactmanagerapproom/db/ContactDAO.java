package com.example.contactmanagerapproom.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.contactmanagerapproom.db.entity.Contact;

import java.util.List;

@Dao
public interface ContactDAO {

    @Insert
    public long insert(Contact contact);

    @Update
    public void updateContact(Contact contact);

    @Delete
    public void delete(Contact contact);

    @Query("select * from contacts")
    public LiveData<List<Contact>> getAllContacts();

    @Query("select * from contacts")
    public List<Contact> getContacts();

    @Query("select * from contacts where contact_id ==:contactId")
    public Contact getContact(long contactId);
}
