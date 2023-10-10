package com.example.contactmanagerapproom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.contactmanagerapproom.adapter.MyAdapter;
import com.example.contactmanagerapproom.databinding.ActivityMainBinding;
import com.example.contactmanagerapproom.db.ContactsDatabase;
import com.example.contactmanagerapproom.db.entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    //Data source
    private ContactsDatabase contactsDatabase;
    private ArrayList<Contact> contacts = new ArrayList<>();
    //Adapter
    private MyAdapter myAdapter;
    //Data Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers handlers;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Data Binding
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);

        mainBinding.setClickHandler(handlers);

        contactsDatabase = ContactsDatabase.getInstance(this);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contacts.addAll(contactsDatabase.getContactDAO().getContacts());
            }
        });
        //Adapter
        myAdapter = new MyAdapter(contacts);
        // RecyclerVIew
        RecyclerView recyclerView = mainBinding.idRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Linking the recyclerView with the adapter
        recyclerView.setAdapter(myAdapter);

        //Database
        contactsDatabase = ContactsDatabase.getInstance(this);

        //ViewModel
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //Loading the data from ROOM DB
        viewModel.getAllContacts().observe(
                this,
                new Observer<List<Contact>>() {
                    @Override
                    public void onChanged(List<Contact> contacts) {
                        contacts.addAll(contacts);
                        myAdapter.notifyDataSetChanged();
                    }
                });

        //swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //if we swipe the item to the left
                Contact c = contacts.get(viewHolder.getAdapterPosition());
                viewModel.deleteContact(c);
                Toast.makeText(MainActivity.this, c.getName()+" deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }
}