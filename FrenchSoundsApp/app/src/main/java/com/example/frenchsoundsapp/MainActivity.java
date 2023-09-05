package com.example.frenchsoundsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button black, green, purple, red, yellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        black = findViewById(R.id.id_black);
        green = findViewById(R.id.id_green);
        purple = findViewById(R.id.id_purple);
        red = findViewById(R.id.id_red);
        yellow = findViewById(R.id.id_yellow);

        black.setOnClickListener(this);
        green.setOnClickListener(this);
        purple.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.id_black){
            playSound(R.raw.black);
        } else if (id==R.id.id_green) {
            playSound(R.raw.green);
        } else if (id==R.id.id_purple) {
            playSound(R.raw.purple);
        } else if (id==R.id.id_red) {
            playSound(R.raw.red);
        }else {
            playSound(R.raw.yellow);
        }
    }

    public void playSound(int sound){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), sound);
        mediaPlayer.start();
    }
}