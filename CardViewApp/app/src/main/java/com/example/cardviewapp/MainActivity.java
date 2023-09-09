package com.example.cardviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardClickListener {

    List<CardItem> cardItemList;
    RecyclerView recyclerView;
    CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_recyclerView);
        cardItemList = new ArrayList<>();

        CardItem item1 = new CardItem(R.drawable.cricket, "Cricket");
        CardItem item2 = new CardItem(R.drawable.football, "Football");
        CardItem item3 = new CardItem(R.drawable.basketball, "BasketBall");
        CardItem item4 = new CardItem(R.drawable.volleyball, "VolleyBall");
        CardItem item5 = new CardItem(R.drawable.swimming, "Swimming");

        cardItemList.add(item1);
        cardItemList.add(item2);
        cardItemList.add(item3);
        cardItemList.add(item4);
        cardItemList.add(item5);

        cardAdapter = new CardAdapter(cardItemList);
        cardAdapter.setOnCardClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cardAdapter);
    }

    @Override
    public void onClickCard(View view, int pos) {
        Toast.makeText(this, cardItemList.get(pos).getSportName()+" Clicked", Toast.LENGTH_SHORT).show();
    }
}