package com.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.id_heading);
        editText = findViewById(R.id.id_name);
        button = findViewById(R.id.id_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                //using explicit intent
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                //Passing the name to the second activity
                i.putExtra("name", userName);
                startActivity(i);
            }
        });
    }
}