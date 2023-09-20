package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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

        editText = findViewById(R.id.id_editText);
        button = findViewById(R.id.id_button);
        textView = findViewById(R.id.id_textView);

        displaySavedText();
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                save(text);
            }
        });
    }

    private void displaySavedText() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE);
        String s = sharedPreferences.getString("name", "");
        textView.setText(s);
    }

    private void save(String txt) {
        textView.setText(txt);
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", txt);
        editor.commit();
    }
}