package com.example.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sphereActivity extends AppCompatActivity {

    EditText sphereRadius;
    TextView resultText;
    Button calButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphereRadius = findViewById(R.id.id_sphereRadius);
        resultText = findViewById(R.id.id_resultSphereVol);
        calButton = findViewById(R.id.id_calSphereVol);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String radius = sphereRadius.getText().toString();
                int r = Integer.parseInt(radius);
                double vol = (4/3)*3.14*r*r*r;
                resultText.setText("Volume = "+vol+" m^3");
            }
        });
    }
}