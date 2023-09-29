package com.example.contactmanagerapproom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactmanagerapproom.adapter.ContactsAdapter;
import com.example.contactmanagerapproom.db.ContactsDatabse;
import com.example.contactmanagerapproom.db.entity.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactsDatabse contactsDatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerVIew
        recyclerView = findViewById(R.id.recycler_view_contacts);

        //Callbacks
        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                //contacts already created in the app
//                CreateContact("amaan", "amaanlm35@gmail.com");
//                CreateContact("ali", "ali35@gmail.com");
//                CreateContact("syed", "syed35@gmail.com");
                Log.i("CREATED DB", "Database has been created");
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
                Log.i("OPENING DB", "Database has been opened");
            }
        };

        //Database
        contactsDatabse = Room.databaseBuilder(getApplicationContext(), ContactsDatabse.class, "ContactDB")
                .addCallback(callback).build();

        // Displaying Contacts List
        displayAllContacts();

        contactsAdapter = new ContactsAdapter(this, contactArrayList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> addAndEditContacts(false, null, -1));
    }

    public void addAndEditContacts(final boolean isUpdated,final Contact contact,final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.layout_add_contact,null);

        AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alerDialogBuilder.setView(view);


        TextView contactTitle = view.findViewById(R.id.new_contact_title);
        final EditText newContact = view.findViewById(R.id.name);
        final EditText contactEmail = view.findViewById(R.id.email);

        contactTitle.setText(!isUpdated ? "Add New Contact" : "Edit Contact");


        if (isUpdated && contact != null){
            newContact.setText(contact.getName());
            contactEmail.setText(contact.getEmail());
        }

        alerDialogBuilder.setCancelable(false)
                .setPositiveButton(isUpdated ? "Update" : "Save", (dialogInterface, i) -> {

                })
                .setNegativeButton("Delete",
                        (dialogInterface, i) -> {
                            if (isUpdated){
                                DeleteContact(contact, position);
                            }else{
                                dialogInterface.cancel();
                            }
                        }
                );

        final AlertDialog alertDialog = alerDialogBuilder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(newContact.getText().toString())){
                Toast.makeText(MainActivity.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();

                return;
            }else{
                alertDialog.dismiss();
            }

            if (isUpdated && contact != null){
                UpdateContact(newContact.getText().toString(), contactEmail.getText().toString(),position);

            }else{
                CreateContact(newContact.getText().toString(), contactEmail.getText().toString());

            }

        });

    }

    private void UpdateContact(String name, String email, int position) {
        Contact contact = contactArrayList.get(position);
        contact.setName(name);
        contact.setEmail(email);
        contactsDatabse.getContactDAO().updateContact(contact);
        contactArrayList.set(position, contact);
        contactsAdapter.notifyDataSetChanged();
    }

    private void CreateContact(String name, String email) {
        long id = contactsDatabse.getContactDAO().addContact(new Contact(name, email, 0));
        Contact contact = contactsDatabse.getContactDAO().getContact(id);
        if(contact!=null){
            contactArrayList.add(0, contact);
            contactsAdapter.notifyDataSetChanged();
        }
    }

    private void DeleteContact(Contact contact, int position) {

        contactArrayList.remove(position);
        contactsDatabse.getContactDAO().deleteContact(contact);
        contactsAdapter.notifyDataSetChanged();

    }

    private void displayAllContacts(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            //background work
            contactArrayList.addAll(contactsDatabse.getContactDAO().getContacts());
            //executed after background work is finished
            handler.post(new Runnable() {
                @Override
                public void run() {
                    contactsAdapter.notifyDataSetChanged();
                }
            });
        });
    }
}