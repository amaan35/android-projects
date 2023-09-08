package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    //Initializing AdapterView - in this case a RecyclerView
    RecyclerView recyclerView;
    //Data Source - A list of Item type, item is a model class we created
    List<Item> itemList;
    //Adapter to bridge the data source with recyclerView
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_recyclerView);
        itemList = new ArrayList<>();

        Item item1 = new Item(R.drawable.apple, "Apple", "Fresh apple from farms");
        Item item2 = new Item(R.drawable.orange, "Orange", "Fresh oranges from farms");
        Item item3 = new Item(R.drawable.banana, "Banana", "Fresh bananas from farms");
        Item item4 = new Item(R.drawable.bread, "Bread", "Fresh bread");
        Item item5 = new Item(R.drawable.broccoli, "Broccoli", "Fresh broccoli");
        Item item6 = new Item(R.drawable.butter, "Butter", "Tasty butter");
        Item item7 = new Item(R.drawable.fish, "Fish meat", "healthy fish meat");
        Item item8 = new Item(R.drawable.meat, "Meat", "Fresh red meat");
        Item item9 = new Item(R.drawable.milk, "Milk", "Fresh milk from the dairy");
        Item item10 = new Item(R.drawable.rusk, "Rusk", "Rusks");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter(itemList);
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Item clicked "+itemList.get(pos).getItemTitle(), Toast.LENGTH_SHORT).show();
    }
}