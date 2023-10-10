package com.example.contactmanagerapproom.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapproom.databinding.ContactListItemBinding;
import com.example.contactmanagerapproom.db.entity.Contact;
import com.example.contactmanagerapproom.MainActivity;
import com.example.contactmanagerapproom.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder>{
    // 1- Variable
    private ArrayList<Contact> contactsList;
    public MyAdapter(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    public void setContactsList(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
        //inform the associated recyclerView that the underlying dataset
        //has changed, and the recyclerView should refresh its views to reflect
        //these changes
        notifyDataSetChanged();
    }

    // 2- ViewHolder
    public class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating new view holders for items in recyclerView
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false
        );
        return new ContactViewHolder(contactListItemBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        //called by recyclerView when it needs to display or update an item
        //at a specific position int the list or grid
        Contact currentContact = contactsList.get(position);
        holder.contactListItemBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        //determines the total number of item in the dataset that will
        //be displayed in the recyclerView
        if(contactsList != null){
            return contactsList.size();
        }
        return 0;
    }
}
