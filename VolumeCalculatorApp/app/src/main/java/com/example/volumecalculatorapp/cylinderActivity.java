package com.example.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cylinderActivity extends AppCompatActivity {

    EditText hEdit, rEdit;
    Button calCylinder;
    TextView resultCylinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        hEdit = findViewById(R.id.id_cylinderHId);
        rEdit = findViewById(R.id.id_cylinderRId);
        calCylinder = findViewById(R.id.id_calCylinder);
        resultCylinder = findViewById(R.id.id_resultCylinder);

        calCylinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = hEdit.getText().toString();
                String r = rEdit.getText().toString();
                int height = Integer.parseInt(h);
                int radius = Integer.parseInt(r);
                double result = 3.14*radius*radius*height;
                resultCylinder.setText("Volume = "+result+" m^3");
            }
        });
    }
}