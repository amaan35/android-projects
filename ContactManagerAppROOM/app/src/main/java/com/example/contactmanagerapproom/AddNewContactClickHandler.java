package com.example.contactmanagerapproom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.contactmanagerapproom.adapter.MyAdapter;
import com.example.contactmanagerapproom.db.entity.Contact;

public class AddNewContactClickHandler {
    private Context context;
    private Contact contact;
    private MyViewModel viewModel;

    public AddNewContactClickHandler(Context context, Contact contact, MyViewModel viewModel) {
        this.context = context;
        this.contact = contact;
        this.viewModel = viewModel;
    }

    public void onSubmitBtnClicked(View view){
        if(contact.getName() == null | contact.getEmail() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(context, MainActivity.class);
//            i.putExtra("name", contact.getName());
//            i.putExtra("email", contact.getEmail());
            Contact c = new Contact(contact.getName(), contact.getEmail());
            viewModel.addNewContact(c);
            context.startActivity(i);
        }
    }
}
