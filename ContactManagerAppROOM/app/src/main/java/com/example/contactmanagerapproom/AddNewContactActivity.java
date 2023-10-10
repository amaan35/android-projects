package com.example.contactmanagerapproom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactmanagerapproom.databinding.ActivityAddNewContactBinding;
import com.example.contactmanagerapproom.db.entity.Contact;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        contact = new Contact();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        handler = new AddNewContactClickHandler(this, contact, viewModel);
        binding.setContact(contact);
        binding.setClickHandler(handler);
    }
}