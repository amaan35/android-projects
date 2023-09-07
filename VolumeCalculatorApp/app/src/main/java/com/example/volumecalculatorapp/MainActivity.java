package com.example.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeArrayList;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.id_gridView);
        shapeArrayList = new ArrayList<>();
        Shape cube = new Shape(R.drawable.cube, "cube");
        Shape sphere = new Shape(R.drawable.sphere, "sphere");
        Shape cylinder = new Shape(R.drawable.cylinder, "cylinder");

        shapeArrayList.add(cube);
        shapeArrayList.add(sphere);
        shapeArrayList.add(cylinder);

        adapter = new CustomAdapter(shapeArrayList, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    intent = new Intent(getApplicationContext(), cubeActivity.class);
                    startActivity(intent);
                }else if(i==1){
                    intent  = new Intent(getApplicationContext(), sphereActivity.class);
                    startActivity(intent);
                }else{
                    intent = new Intent(getApplicationContext(), cylinderActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}