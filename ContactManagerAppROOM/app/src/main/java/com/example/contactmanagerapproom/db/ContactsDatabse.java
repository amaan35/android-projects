package com.example.contactmanagerapproom.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.contactmanagerapproom.db.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsDatabse extends RoomDatabase {
    public abstract ContactDAO getContactDAO();
}
