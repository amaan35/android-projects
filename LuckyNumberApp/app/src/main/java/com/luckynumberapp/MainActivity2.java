package com.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView luckyNumber;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        luckyNumber = findViewById(R.id.id_luckyNumber);
        shareButton = findViewById(R.id.id_shareButton);
        //receiving data from previous activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        //generating random numbers
        int randomNum = generateRandomNumbers();
        luckyNumber.setText(""+randomNum);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(userName, randomNum);
            }
        });
    }

    public void share(String user, int num){
        //implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //additional information
        i.putExtra(Intent.EXTRA_SUBJECT, user+"'s lucky number!!!");
        i.putExtra(Intent.EXTRA_TEXT, "His/Her lucky number is : "+num);
        startActivity(Intent.createChooser(i, "choose platform"));
    }

    public int generateRandomNumbers(){
        Random random = new Random();
        int upper_limit = 100;
        int randomNumber = random.nextInt(upper_limit);
        return randomNumber;
    }
}